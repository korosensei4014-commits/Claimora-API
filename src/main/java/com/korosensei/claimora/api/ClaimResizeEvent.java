package com.korosensei.claimora.api;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/** A claim or subclaim is about to change size. The new corners are inclusive block coordinates. */
public final class ClaimResizeEvent extends ClaimEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ClaimInfo claim;
    private final int newMinX, newMinZ, newMaxX, newMaxZ;

    public ClaimResizeEvent(ClaimInfo claim, int newMinX, int newMinZ, int newMaxX, int newMaxZ) {
        this.claim = claim;
        this.newMinX = newMinX;
        this.newMinZ = newMinZ;
        this.newMaxX = newMaxX;
        this.newMaxZ = newMaxZ;
    }

    public ClaimInfo getClaim() {
        return claim;
    }

    public int getNewMinX() {
        return newMinX;
    }

    public int getNewMinZ() {
        return newMinZ;
    }

    public int getNewMaxX() {
        return newMaxX;
    }

    public int getNewMaxZ() {
        return newMaxZ;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
