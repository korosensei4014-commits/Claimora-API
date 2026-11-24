package com.korosensei.claimora.api;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * A player is about to be banned from (or unbanned from) a main claim. A ban covers the claim's
 * subclaims too, and banning also removes the player's trust in the claim and its subclaims.
 *
 * @since 0.8.6
 */
public final class ClaimBanEvent extends ClaimEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ClaimInfo claim;
    private final UUID player;
    private final boolean banning;

    public ClaimBanEvent(ClaimInfo claim, UUID player, boolean banning) {
        this.claim = claim;
        this.player = player;
        this.banning = banning;
    }

    public ClaimInfo getClaim() {
        return claim;
    }

    public UUID getPlayer() {
        return player;
    }

    /** True when banning, false when unbanning. */
    public boolean isBanning() {
        return banning;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
