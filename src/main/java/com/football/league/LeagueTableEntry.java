package com.football.league;

/**
 * The Class LeagueTableEntry holds details of a match including points earned and goals.
 */
public class LeagueTableEntry {

	private String teamName;
	private int played;
	private int won;
	private int drawn;
	private int lost;
	private int goalsFor;
	private int goalsAgainst;
	private int goalDifference;
	private int points;

	/**
	 * Instantiates a new league table entry.
	 *
	 * @param teamName the team name
	 * @param played the played
	 * @param won the won
	 * @param drawn the drawn
	 * @param lost the lost
	 * @param goalsFor the goals for
	 * @param goalsAgainst the goals against
	 * @param goalDifference the goal difference
	 * @param points the points
	 */
	public LeagueTableEntry(String teamName, int played, int won, int drawn, int lost, int goalsFor, int goalsAgainst,
			int goalDifference, int points) {
		this.teamName = teamName;
		this.played = played;
		this.won = won;
		this.drawn = drawn;
		this.lost = lost;
		this.goalsFor = goalsFor;
		this.goalsAgainst = goalsAgainst;
		this.goalDifference = goalDifference;
		this.points = points;
	}

	/**
	 * Gets the team name.
	 *
	 * @return the team name
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * Sets the team name.
	 *
	 * @param teamName the new team name
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * Gets the played.
	 *
	 * @return the played
	 */
	public int getPlayed() {
		return played;
	}

	/**
	 * Sets the played.
	 *
	 * @param played the new played
	 */
	public void setPlayed(int played) {
		this.played = played;
	}

	/**
	 * Gets the won.
	 *
	 * @return the won
	 */
	public int getWon() {
		return won;
	}

	/**
	 * Sets the won.
	 *
	 * @param won the new won
	 */
	public void setWon(int won) {
		this.won = won;
	}

	/**
	 * Gets the drawn.
	 *
	 * @return the drawn
	 */
	public int getDrawn() {
		return drawn;
	}

	/**
	 * Sets the drawn.
	 *
	 * @param drawn the new drawn
	 */
	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	/**
	 * Gets the lost.
	 *
	 * @return the lost
	 */
	public int getLost() {
		return lost;
	}

	/**
	 * Sets the lost.
	 *
	 * @param lost the new lost
	 */
	public void setLost(int lost) {
		this.lost = lost;
	}

	/**
	 * Gets the goals for.
	 *
	 * @return the goals for
	 */
	public int getGoalsFor() {
		return goalsFor;
	}

	/**
	 * Sets the goals for.
	 *
	 * @param goalsFor the new goals for
	 */
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	/**
	 * Gets the goals against.
	 *
	 * @return the goals against
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	/**
	 * Sets the goals against.
	 *
	 * @param goalsAgainst the new goals against
	 */
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	/**
	 * Gets the goal difference.
	 *
	 * @return the goal difference
	 */
	public int getGoalDifference() {
		return goalDifference;
	}

	/**
	 * Sets the goal difference.
	 *
	 * @param goalDifference the new goal difference
	 */
	public void setGoalDifference(int goalDifference) {
		this.goalDifference = goalDifference;
	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 *
	 * @param points the new points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString()
	{
		return "LeagueTableEntry [teamName=" + teamName + ", goalsFor=" + goalsFor + ", goalDifference=" + goalDifference + ", points=" + points + "]";
	}
}
