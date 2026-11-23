package com.korosensei.claimora.api;

import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

/**
 * Read-only view of a claim or subclaim, as handed to other plugins.
 * Don't keep these for long: a resized claim is replaced by a new object with the same id.
 * Store the {@link #id()} instead and look it up again.
 */
public interface ClaimInfo {

    long id();

    UUID worldId();

    int minX();

    int minZ();

    int maxX();

    int maxZ();

    /** Footprint in blocks; what a main claim costs. */
    long area();

    /** Null for admin claims. */
    @Nullable UUID owner();

    String name();

    /** Players trusted in this claim or subclaim (an unmodifiable view). */
    Set<UUID> trusted();

    boolean isSubclaim();

    /** The player's trust level here, or null if they aren't trusted (the owner isn't "trusted"). */
    @Nullable TrustLevel trustLevel(UUID player);

    /** Id of the main claim, or -1 for a main claim. */
    long parentId();

    boolean contains(int x, int z);
}
