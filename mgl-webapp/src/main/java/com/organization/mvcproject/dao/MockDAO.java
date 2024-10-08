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
	
	public Game findGameById(Long id)
	{
	
		Game temp = null;
		for(Game g : games) {
			if(g.getId().equals(id))
				temp = g;
		}
		return temp;
	}

	public Game saveGame(Game game) {
	Game temp = findGameById(game.getId());
	if(temp != null)
	{
		temp.setName(game.getName());
		temp.setGenre(game.getGenre());
	} else {
		game.setId(++gameId);
		games.add((Game) game);
	}	
        return game; 
	
	}
	
	public Long deleteGame(Long id) {
		for(Game g: games) {
			if ( g.getId().equals(id)) {
				games.remove(g);
				break;
			}
		}
		return id;
	}
	
}
