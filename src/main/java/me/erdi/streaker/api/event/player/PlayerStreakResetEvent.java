package me.erdi.streaker.api.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerStreakResetEvent extends PlayerEvent implements Cancellable {
	private static final HandlerList HANDLERS = new HandlerList();
	
	private boolean cancelled;
	private final int oldStreak;
	
	public PlayerStreakResetEvent(Player who, int oldStreak) {
		super(who);
		this.oldStreak = oldStreak;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		cancelled = cancel;
	}
	
	public int getOldStreak() {
		return oldStreak;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}
