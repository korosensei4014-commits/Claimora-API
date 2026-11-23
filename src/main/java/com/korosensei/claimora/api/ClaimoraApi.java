package com.korosensei.claimora.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Claimora's API for other plugins. Get it with {@link #get()} (or Bukkit's ServicesManager).
 * Call it from the main thread.
 *
 * <pre>{@code
 * ClaimoraApi api = ClaimoraApi.get();
 * if (api != null && !api.canBuild(player, location)) { ... }
 * }</pre>
 */
public interface ClaimoraApi {

    /** The most specific claim at a location: a subclaim if inside one, otherwise the main claim. */
    Optional<ClaimInfo> claimAt(Location location);

    /** Whether the player may build and interact at the location under Claimora's rules. */
    boolean canBuild(Player player, Location location);

    /** Main claims owned by the player. */
    List<ClaimInfo> claimsOf(UUID owner);

    Optional<ClaimInfo> claimById(long id);

    /**
     * Gives (or with a negative amount, takes) claim blocks. Works for offline players too.
     * Completes on the main thread with the player's new available balance.
     */
    CompletableFuture<Long> giveClaimBlocks(UUID player, long amount);

    /** Available claim blocks of an online player, or empty if they are offline. */
    Optional<Long> availableBlocks(UUID player);

    /** The registered API, or null if Claimora isn't enabled. Not cached, so nothing outlives Claimora. */
    static @Nullable ClaimoraApi get() {
        RegisteredServiceProvider<ClaimoraApi> rsp = Bukkit.getServicesManager().getRegistration(ClaimoraApi.class);
        return rsp == null ? null : rsp.getProvider();
    }
}
