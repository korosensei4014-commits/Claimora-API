package com.korosensei.claimora.api;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * A claim or subclaim is about to be created. Example: cancel it near a dungeon entrance,
 * or announce it on Discord (listen at MONITOR and check {@link #isCancelled()}).
 */
public final class ClaimCreateEvent extends ClaimEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID owner;
    private final UUID worldId;
    private final int minX, minZ, maxX, maxZ;
    private final @Nullable ClaimInfo parent;

    public ClaimCreateEvent(@Nullable UUID owner, UUID worldId, int minX, int minZ, int maxX, int maxZ, @Nullable ClaimInfo parent) {
        this.owner = owner;
        this.worldId = worldId;
        this.minX = minX;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxZ = maxZ;
        this.parent = parent;
    }

    /** Null for an admin (server) claim, or a subclaim inside one. */
    public @Nullable UUID getOwner() {
        return owner;
    }

    public UUID getWorldId() {
        return worldId;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinZ() {
        return minZ;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxZ() {
        return maxZ;
    }

    public long getArea() {
        return (long) (maxX - minX + 1) * (maxZ - minZ + 1);
    }

    /** The main claim, if this is a subclaim. */
    public @Nullable ClaimInfo getParent() {
        return parent;
    }

    public boolean isSubclaim() {
        return parent != null;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
