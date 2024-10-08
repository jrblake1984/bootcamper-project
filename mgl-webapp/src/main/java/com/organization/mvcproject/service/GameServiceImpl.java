package com.organization.mvcproject.service;

import java.util.ArrayList;
import com.organization.mvcproject.dao.MockDAO;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;

@Service
public class GameServiceImpl implements GameService {

	private MockDAO dao = new MockDAO();

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