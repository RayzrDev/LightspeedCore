package me.rayzr522.lightspeedcore.api.modules;

import me.rayzr522.lightspeedcore.LightspeedCore;
import me.rayzr522.lightspeedcore.api.commands.ModuleCommand;
import me.rayzr522.lightspeedcore.api.storage.IStorageProvider;
import me.rayzr522.lightspeedcore.api.storage.impl.PlayerData;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Represents a module, which handles data or other various shared aspects of multiple commands or systems.
 * <p>
 * Created by Rayzr522 on 5/27/17.
 */
public interface IModule {
    /**
     * Called when {@link LightspeedCore} loads.
     *
     * @param core The {@link LightspeedCore} instance.
     */
    void onLoad(LightspeedCore core);

    /**
     * @return The {@link LightspeedCore} instance associated with this plugin.
     */
    LightspeedCore getPlugin();

    /**
     * @return The settings for this module.
     */
    IStorageProvider getSettings();

    /**
     * @return The storage provider for this module.
     */
    IStorageProvider getStorage();

    /**
     * Gets the player data associated with this module for the given player.
     *
     * @param player The UUID of the player.
     * @return The {@link PlayerData}.
     */
    PlayerData getPlayerData(UUID player);

    /**
     * @return The name of this module.
     */
    String getName();

    /**
     * @return Any commands associated with this module.
     */
    default List<ModuleCommand> getCommands() {
        return Collections.emptyList();
    }
}
