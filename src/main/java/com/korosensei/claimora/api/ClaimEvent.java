package com.korosensei.claimora.api;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

/**
 * Base of Claimora's events. All are fired on the main thread just before a change is saved,
 * and cancelling one stops the change. Don't keep the {@link ClaimInfo} objects after the event.
 */
public abstract class ClaimEvent extends Event implements Cancellable {

    private boolean cancelled;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
