"use strict";

(function () {

    angular.module("cinema").service("movieDal", ["dal", MovieDal]);

    function MovieDal (dal) {

    	   this.getMovie = function (id) {
            return dal.http.GET("api/v1/movie/" + id);
        }; 
        
    	   this.getMovies = function () {
            return dal.http.GET("api/v1/movie");
        };

        this.saveMovie = function (movieToSave) {
            return dal.http.POST("api/v1/movie", movieToSave);
        };

        this.updateMovie = function (movieToUpdate) {
            return dal.http.PUT("api/v1/movie/", movieToUpdate);
        };

        this.deleteMovie = function (movieToDelete) {
            return dal.http.DELETE("api/v1/movie/", movieToDelete);
        };

    }
}());
