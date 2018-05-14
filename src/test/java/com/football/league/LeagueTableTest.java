package com.football.league;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeagueTableTest {
	
	private LeagueTable leagueTable;
	
	@Test
	public void testLeagueTableWithMatchesSetAsNull() {
		leagueTable = new LeagueTable(null);
		
		assertEquals(0, leagueTable.getTableEntries().size());
	}
	
	@Test
	public void testLeagueTableWithMatchesSetAsEmpty() {
		leagueTable = new LeagueTable(new ArrayList<>());
		
		assertEquals(0, leagueTable.getTableEntries().size());
	}
	
	@Test
	public void testLeagueTableWithOnlyOneTeam() {
		List<Match> matches = new ArrayList<>();
		Match match = new Match("homeTeam1", "awayTeam1", 4, 1);
		matches.add(match );
		leagueTable = new LeagueTable(matches);
		
		assertEquals(2, leagueTable.getTableEntries().size());
	}
	
	@Test
	public void testLeagueTableCorrectly() {
		List<Match> matches = new ArrayList<>();
		Match match = new Match("homeTeam1", "awayTeam1", 4, 1);
		matches.add(match );
		Match match2 = new Match("homeTeam2", "awayTeam2", 2, 1);
		matches.add(match2);
		Match match3 = new Match("homeTeam1", "awayTeam2", 1, 1);
		matches.add(match3);
		
		leagueTable = new LeagueTable(matches);
		assertEquals(4, leagueTable.getTableEntries().size());
		
		for (LeagueTableEntry entry : leagueTable.getTableEntries()) {
			if("homeTeam1".equalsIgnoreCase(entry.getTeamName())) {
				assertEquals(1, entry.getWon());
				assertEquals(0, entry.getLost());
				assertEquals(1, entry.getDrawn());
				assertEquals(2, entry.getPlayed());
			} else if ("homeTeam2".equalsIgnoreCase(entry.getTeamName())) {
				assertEquals(1, entry.getWon());
				assertEquals(0, entry.getLost());
				assertEquals(0, entry.getDrawn());
				assertEquals(1, entry.getPlayed());
			} else if ("awayTeam1".equalsIgnoreCase(entry.getTeamName())) {
				assertEquals(0, entry.getWon());
				assertEquals(1, entry.getLost());
				assertEquals(0, entry.getDrawn());
				assertEquals(1, entry.getPlayed());
			} else if ("awayTeam2".equalsIgnoreCase(entry.getTeamName())) {
				assertEquals(0, entry.getWon());
				assertEquals(1, entry.getLost());
				assertEquals(1, entry.getDrawn());
				assertEquals(2, entry.getPlayed());
			}
		}
	}
}
