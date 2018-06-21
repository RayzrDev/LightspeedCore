package me.rayzr522.lightspeedcore.commands;

import me.rayzr522.lightspeedcore.LightspeedCore;
import me.rayzr522.lightspeedcore.api.commands.CommandContext;
import me.rayzr522.lightspeedcore.api.commands.CommandResult;
import me.rayzr522.lightspeedcore.api.commands.CommandTarget;
import me.rayzr522.lightspeedcore.api.commands.ICommandHandler;
import org.bukkit.Bukkit;

import java.util.Collections;
import java.util.List;

public class CommandAdminChat implements ICommandHandler {
    @Override
    public String getCommandName() {
        return "adminchat";
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("ac");
    }

    @Override
    public String getPermission() {
        return "adminchat";
    }

    @Override
    public List<CommandTarget> getTargets() {
        return CommandTarget.PLAYER.only();
    }

    @Override
    public CommandResult onCommand(CommandContext ctx) {
        if (!ctx.hasArgs()) {
            return CommandResult.SHOW_USAGE;
        }

        broadcastMessage(ctx.getSender().getName(), ctx.remainder());

        return CommandResult.SUCCESS;
    }

    private void broadcastMessage(String sender, String message) {
        LightspeedCore plugin = getPlugin();
        String translatedMessage = plugin.trRaw("command.adminchat.message-format", sender, message);

        Bukkit.getOnlinePlayers().stream()
                .filter(player -> plugin.checkPermission(player, "adminchat", false))
                .forEach(admin -> admin.sendMessage(translatedMessage));
    }
}
