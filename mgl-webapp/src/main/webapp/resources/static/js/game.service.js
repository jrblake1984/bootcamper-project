'use strict';

angular.module('GameApp').factory('GameService', ['$http', function($http) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame: deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'getAll').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + "createGame", game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function deleteGame(game) {
			return $http.delete(REST_SERVICE_URI + "deleteGame/" + game.id, game.id).then(function(response) {
					return response.data;
				}
			);
		}

}]);
