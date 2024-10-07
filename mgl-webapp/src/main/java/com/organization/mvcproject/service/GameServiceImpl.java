package com.organization.mvcproject.service;

import java.util.ArrayList;
import com.organization.mvcproject.dao.MockDAO;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;

@Service
public class GameServiceImpl implements GameService {

	private MockDAO dao = new MockDAO();
	/**
	 * TODO 2.0 The class that interacts with persistent data is called a Data Access Object(DAO)
	 *  or a Repository class. The private static list is mocking our persistance of games.
	 *   
	 *  Move this list, and methods operating on this list to an appropriately named package and class.
	 */
	
	@Override
	public List<Game> retrieveAllGames() {
		return dao.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		dao.saveGame(game);

		return game;
	}
	
	@Override
	public Game deleteGame(Game game)
	{
		dao.deleteGame(game);
		return game;
	}
	


}