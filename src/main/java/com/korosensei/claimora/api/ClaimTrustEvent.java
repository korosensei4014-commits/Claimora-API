package com.korosensei.claimora.api;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/** A player is about to be trusted in (or removed from, or moved to another level in) a claim or subclaim. */
public final class ClaimTrustEvent extends ClaimEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ClaimInfo claim;
    private final UUID player;
    private final boolean trusted;
    private final TrustLevel level;

    public ClaimTrustEvent(ClaimInfo claim, UUID player, boolean trusted) {
        this(claim, player, trusted, TrustLevel.BUILD);
    }

    public ClaimTrustEvent(ClaimInfo claim, UUID player, boolean trusted, TrustLevel level) {
        this.claim = claim;
        this.player = player;
        this.trusted = trusted;
        this.level = level;
    }

    /** The level being given (when trusting) or the level being removed (when untrusting). */
    public TrustLevel getLevel() {
        return level;
    }

    public ClaimInfo getClaim() {
        return claim;
    }

    public UUID getPlayer() {
        return player;
    }

    /** True when trusting, false when untrusting. */
    public boolean isTrusting() {
        return trusted;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
