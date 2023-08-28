package me.erdi.streaker.api.event.player;

import javax.annotation.Nonnull;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerEvent;

public class PlayerKillStreakEvent extends PlayerEvent implements Cancellable {
	private static final HandlerList HANDLERS = new HandlerList();
	
	private final Player killed;
	private final PlayerDeathEvent responsibleEvent;
	private int streak;

	private boolean cancelled;
	
	public PlayerKillStreakEvent(Player player, Player killed, PlayerDeathEvent responsibleEvent, int streak) {
		super(player);

		this.killed = killed;
		this.responsibleEvent = responsibleEvent;
		this.streak = streak;
	}

	/**
	 * @return The player who was killed
	 */
	@Nonnull
	public Player getKilled() {
		return killed;
	}
	
	/**
	 * @return The streak about to be set on the player
	 */
	public int getStreak() {
		return streak;
	}
	
	/**
	 * Set the player's streak
	 * @param streak
	 */
	public void setStreak(int streak) {
		this.streak = streak;
	}
	
	/**
	 * @return PlayerDeathEvent that caused this event to be fired
	 */
	@Nonnull
	public PlayerDeathEvent getResponsibleEvent() {
		return responsibleEvent;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	/**
	 * Warning: This does not cancel the death event! For that, see {@link #getResponsibleEvent()}
	 */
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
	}
}
