package com.korosensei.claimora.api;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/** A claim or subclaim is about to be removed. Removing a main claim also removes its subclaims. */
public final class ClaimDeleteEvent extends ClaimEvent {

    public enum Reason { ABANDONED, ADMIN, EXPIRED, PLUGIN }

    private static final HandlerList HANDLERS = new HandlerList();

    private final ClaimInfo claim;
    private final Reason reason;

    public ClaimDeleteEvent(ClaimInfo claim, Reason reason) {
        this.claim = claim;
        this.reason = reason;
    }

    public ClaimInfo getClaim() {
        return claim;
    }

    public Reason getReason() {
        return reason;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
