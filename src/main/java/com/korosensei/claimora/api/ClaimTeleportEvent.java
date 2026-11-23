package com.korosensei.claimora.api;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * A player is starting a teleport to a claim with /claim tp (fired before the warm-up).
 * Cancel it to block the teleport, e.g. while the player is in combat.
 */
public final class ClaimTeleportEvent extends ClaimEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final ClaimInfo claim;

    public ClaimTeleportEvent(Player player, ClaimInfo claim) {
        this.player = player;
        this.claim = claim;
    }

    public Player getPlayer() {
        return player;
    }

    public ClaimInfo getClaim() {
        return claim;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
