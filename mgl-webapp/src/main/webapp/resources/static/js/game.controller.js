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
			
			
			self.sortByGenre = function()
			{
				self.games.sort((a,b)=> a.genre.localeCompare(b.genre));
			}
			
			self.sortByGenreD = function()
			{
				self.games.sort((a,b)=> b.genre.localeCompare(a.genre));
			}

			self.fetchAllGames = function(){
				GameService.fetchAllGames().then(function(data) {
					self.games = data;

				});
			}

			self.addGame = function(){
				return GameService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			self.deleteGame = function(game){
				return GameService.deleteGame(game).then( function() {
				self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
