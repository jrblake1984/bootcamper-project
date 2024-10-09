'use strict';

angular.module('GameApp').controller('GameController',
		[ 'GameService', function(GameService) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};

			self.games = [];
			
		
			self.clearGame = function()
			{
				self.game = null;
			}
			
			self.sortByGenre = function()
			{
				self.games.sort((a,b)=> a.genre.localeCompare(b.genre));
			}
			
			self.sortByGenreD = function()
			{
				self.games.sort((a,b)=> b.genre.localeCompare(a.genre));
			}
			
			self.selectGame = function(game)
			{
				self.game = angular.copy(game);
			}

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;

				});
			}

			self.addGame = function(){

				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				self.clearGame();
				});
			}
			
			self.deleteGame = function(game){
				return GameService.deleteGame(game).then( function() {
				self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
