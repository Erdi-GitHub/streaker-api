package me.erdi.streaker.api;

import org.bukkit.entity.Player;

public interface StreakerApi {
	/**
	 * Globally disable kill-streaks
	 * @param enabled
	 */
	void setStreakEnabled(boolean enabled);
	/**
	 * Check if kill-streaks are enabled
	 * @return whether kill-streaks are enabled
	 */
	boolean isStreakEnabled();
	/**
	 * A person's kill-streak
	 * @param whose whose kill-streak to get
	 * @return the specified player's kill-streak
	 */
	int getStreak(Player whose);
	/**
	 * Set a person's kill-streak
	 * @param whose whose kill-streak to set
	 * @param streak kill-streak
	 */
	void setStreak(Player whose, int streak);
}
