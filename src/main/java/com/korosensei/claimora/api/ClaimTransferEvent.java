package com.korosensei.claimora.api;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/** A main claim (with its subclaims) is about to be given to another player with /claim transfer. */
public final class ClaimTransferEvent extends ClaimEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ClaimInfo claim;
    private final UUID oldOwner;
    private final UUID newOwner;

    public ClaimTransferEvent(ClaimInfo claim, UUID oldOwner, UUID newOwner) {
        this.claim = claim;
        this.oldOwner = oldOwner;
        this.newOwner = newOwner;
    }

    public ClaimInfo getClaim() {
        return claim;
    }

    /** Null when the claim was an admin (server) claim. */
    public @org.jetbrains.annotations.Nullable UUID getOldOwner() {
        return oldOwner;
    }

    /** Null when the claim becomes an admin (server) claim. */
    public @org.jetbrains.annotations.Nullable UUID getNewOwner() {
        return newOwner;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
