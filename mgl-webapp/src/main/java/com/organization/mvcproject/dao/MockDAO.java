package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import com.organization.mvcproject.model.Game;

public class MockDAO {
	private static Long gameId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}


	public List<Game> retrieveAllGames() {
		return games;
	}
	
	public Game findGameById(Game game)
	{
		Game temp = null;
		for(Game g : games)
			if(g.getId().equals(game.getId()))
				temp = g;
		return temp;
	}
	/*
	public Game saveGame(Game game) {
		System.out.println(game);
		game.setId(++gameId);
		games.add(game);
		
		return game;
		
	}
	*/
	
	public Game findGameById(Long id) {
		
		//for each loop
		for (Game g : games) {
			if(id.equals(g.getId())) {
				return g; 
			}
		}
		// if no game was found
		return null; 
	}
	
	public Game saveGame(Game game) {
		if( game.getId() != null) {
			Game foundGame = findGameById(game.getId());
		    if(foundGame != null) {
		    	//update the game in the list
		    	for (int i = 0; i < games.size(); i++ ) {
					if(game.getId().equals(games.get(i).getId())) {
					    return games.set(i, game);
					}
		    	}
		    } 
		} 
		
	    game.setId(++gameId);
        games.add((Game) game);
        return game; 
	
	}
	
	public Game deleteGame(Game game) {
		
		for(Game g: games) {
			if ( game.getId().equals(g.getId())) {
				games.remove(g);
			}
		}
		System.out.println("Test");
		return game;
	}
	
}
