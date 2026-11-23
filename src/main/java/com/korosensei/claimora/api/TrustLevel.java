package com.korosensei.claimora.api;

import org.jetbrains.annotations.Nullable;

import java.util.Locale;

/**
 * How much a trusted player may do in a claim. Each level includes everything below it.
 * The owner (and admins in bypass mode) can always do everything.
 */
public enum TrustLevel {
    /** Doors, trapdoors, gates, buttons, levers, pressure plates, beds, bells; riding vehicles. */
    GUEST(1, "guest"),
    /** Guest, plus containers, animals and farming (harvesting and replanting crops). */
    CONTAINERS(2, "containers"),
    /** Containers, plus breaking and placing anything. What plain /trust gives. */
    BUILD(3, "build"),
    /** Build, plus trusting and untrusting other players (up to Build). */
    MANAGER(4, "manager");

    private final int rank;
    private final String key;

    TrustLevel(int rank, String key) {
        this.rank = rank;
        this.key = key;
    }

    /** Stored in the database (claim_trust.level). */
    public int rank() {
        return rank;
    }

    /** "guest", "containers", "build" or "manager" (commands, config, messages). */
    public String key() {
        return key;
    }

    public boolean atLeast(TrustLevel other) {
        return rank >= other.rank;
    }

    public static TrustLevel ofRank(int rank) {
        for (TrustLevel l : values()) if (l.rank == rank) return l;
        return BUILD;
    }

    public static @Nullable TrustLevel byKey(String key) {
        String k = key.toLowerCase(Locale.ROOT).strip();
        for (TrustLevel l : values()) if (l.key.equals(k)) return l;
        return switch (k) { // a few friendly aliases
            case "access", "visitor" -> GUEST;
            case "container", "chest", "chests" -> CONTAINERS;
            case "builder" -> BUILD;
            case "manage", "managers", "permission" -> MANAGER;
            default -> null;
        };
    }
}
