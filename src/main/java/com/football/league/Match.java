package com.football.league;

/**
 * The Class Match holds the result of each match.
 */
public class Match {
	
	/** The home team. */
	private String homeTeam;
	
	/** The away team. */
	private String awayTeam;
	
	/** The home score. */
	private int homeScore;
	
	/** The away score. */
	private int awayScore;
	
	/**
	 * Instantiates a new match.
	 *
	 * @param homeTeam the home team
	 * @param awayTeam the away team
	 * @param homeScore the home score
	 * @param awayScore the away score
	 */
	public Match(final String homeTeam, final String awayTeam, final int homeScore, final int awayScore) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
	}
	
	/**
	 * Gets the home team.
	 *
	 * @return the home team
	 */
	public String getHomeTeam() {
		return homeTeam;
	}
	
	/**
	 * Sets the home team.
	 *
	 * @param homeTeam the new home team
	 */
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	/**
	 * Gets the away team.
	 *
	 * @return the away team
	 */
	public String getAwayTeam() {
		return awayTeam;
	}
	
	/**
	 * Sets the away team.
	 *
	 * @param awayTeam the new away team
	 */
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	/**
	 * Gets the home score.
	 *
	 * @return the home score
	 */
	public int getHomeScore() {
		return homeScore;
	}
	
	/**
	 * Sets the home score.
	 *
	 * @param homeScore the new home score
	 */
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	
	/**
	 * Gets the away score.
	 *
	 * @return the away score
	 */
	public int getAwayScore() {
		return awayScore;
	}
	
	/**
	 * Sets the away score.
	 *
	 * @param awayScore the new away score
	 */
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
}
