package com.football.league;

import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;

/**
 * The Class LeagueTable is used to generate league table from the matches played.
 */
public class LeagueTable {
	
	private List<Match> matches;
	

	/**
	 * Instantiates a new league table.
	 *
	 * @param matches the matches
	 */
	public LeagueTable(final List<Match> matches) {
		this.matches = matches;
	}
	
	/**
	 * Gets the table entries based on match played by each team.
	 *
	 * @return the table entries
	 */
	public List<LeagueTableEntry> getTableEntries() {
		final List<LeagueTableEntry> leagueTableEntries = new ArrayList<LeagueTableEntry>();
		
		if(CollectionUtils.isEmpty(matches)) {
			return leagueTableEntries;
		}
		//get team list from matches
		Set<String> teams = Stream.concat(matches.stream().map(Match::getHomeTeam), matches.stream().map(Match::getAwayTeam)).collect(toSet());
		//populate league table for each team
		teams.forEach(team -> addLeagueTableEntry(team, leagueTableEntries, getMatchesByTeam(team, matches)));
				
		return sortTableEntries(leagueTableEntries);
	}

	/**
	 * Sort table entries based on points, goal difference, goalsFor and then team name.
	 *
	 * @param entries the entries
	 * @return the list
	 */
	private List<LeagueTableEntry> sortTableEntries(List<LeagueTableEntry> entries) {
		// Sorting on multiple fields using Java 8 lambda expressions
		Comparator<LeagueTableEntry> groupByComparator = Comparator.comparing(LeagueTableEntry::getPoints)
				.thenComparing(LeagueTableEntry::getGoalDifference)
				.thenComparing(LeagueTableEntry::getGoalsFor)
				.thenComparing(LeagueTableEntry::getTeamName);

		List<LeagueTableEntry> leagueEntries = new ArrayList<>(entries);
		leagueEntries.sort(groupByComparator.reversed());

		return leagueEntries;
	}

	/**
	 * Adds the league table entry.
	 *
	 * @param team the team
	 * @param leagueTableEntries 
	 * @param matchesByTeam the matches by team
	 */
	private void addLeagueTableEntry(final String team, final List<LeagueTableEntry> leagueTableEntries, final List<Match> matchesByTeam) {
		final int won = getTotalWon(team, matchesByTeam);
		final int drawn = getTotalDrawn(team, matchesByTeam);
		final int lost = getTotalLost(team, matchesByTeam);
		
		final int goalsFor = getGoalsFor(team, matchesByTeam);
		final int goalsAgainst = getGoalsAgainst(team, matchesByTeam);
		final int goalDifference = goalsFor - goalsAgainst;
		final int points = (won * 3) + (drawn * 1);
		
		LeagueTableEntry entry = new LeagueTableEntry(team, matchesByTeam.size(), won, drawn, lost, goalsFor, goalsAgainst, goalDifference, points);
		leagueTableEntries.add(entry);
	}

	/**
	 * Gets the goals against.
	 *
	 * @param team the team
	 * @param matchesByTeam the matches by team
	 * @return the goals against
	 */
	private int getGoalsAgainst(String team, List<Match> matchesByTeam) {
		return matches.stream().map(match -> {			
			boolean isHomeMatch = match.getHomeTeam().equals(team);
			return (isHomeMatch) ? match.getAwayScore():match.getHomeScore();			
		}).reduce(0, Integer::sum);
	}

	/**
	 * Gets the goals for.
	 *
	 * @param team the team
	 * @param matchesByTeam the matches by team
	 * @return the goals for
	 */
	private int getGoalsFor(String team, List<Match> matchesByTeam) {
		return matches.stream().map(match -> {			
			boolean isHomeMatch = match.getHomeTeam().equals(team);
			return (isHomeMatch) ? match.getHomeScore():match.getAwayScore();			
		}).reduce(0, Integer::sum);
	}

	/**
	 * Gets the total lost.
	 *
	 * @param team the team
	 * @param matchesByTeam the matches by team
	 * @return the total lost
	 */
	private int getTotalLost(String team, List<Match> matchesByTeam) {
		Set<Match> teams = Stream.concat(matches.stream().filter(match -> {
			if(match.getHomeTeam().equals(team)){
				return match.getHomeScore() < match.getAwayScore();
			}	
			return false;
		}), 
		matches.stream().filter(match -> {
			if(match.getAwayTeam().equals(team)){
				return match.getAwayScore() < match.getHomeScore();
			}	
			return false;
		})).collect(toSet());

	return teams.size();
	}

	/**
	 * Gets the total drawn.
	 *
	 * @param team the team
	 * @param matchesByTeam the matches by team
	 * @return the total drawn
	 */
	private int getTotalDrawn(String team, List<Match> matchesByTeam) {
		Set<Match> teams = matches.stream().filter(match -> {
			if(match.getHomeTeam().equals(team) || match.getAwayTeam().equals(team)){
				return match.getHomeScore() == match.getAwayScore();
			}	
			return false;
		}).collect(toSet());

		return teams.size();
	}

	/**
	 * Gets the total won.
	 *
	 * @param team the team
	 * @param matchesByTeam the matches by team
	 * @return the total won
	 */
	private int getTotalWon(String team, List<Match> matchesByTeam) {
		
		
		Set<Match> teams = Stream.concat(matches.stream().filter(match -> {
					if(match.getHomeTeam().equals(team)){
						return match.getHomeScore() > match.getAwayScore();
					}	
					return false;
				}), 
				matches.stream().filter(match -> {
					if(match.getAwayTeam().equals(team)){
						return match.getAwayScore() > match.getHomeScore();
					}	
					return false;
				})).collect(toSet());
		
		return teams.size();
	}

	/**
	 * Gets the matches by team.
	 *
	 * @param team the team
	 * @param matches the matches
	 * @return the matches by team
	 */
	/*
	 * Returns the matches where the provided team is specified as homeTeam or awayTeam.
	 * 
	 */
	private List<Match> getMatchesByTeam(String team, List<Match> matches) {
		return matches.stream()
		.filter(match -> match.getHomeTeam().equals(team) || match.getAwayTeam().equals(team))
		.collect(Collectors.toList());
	}

}
