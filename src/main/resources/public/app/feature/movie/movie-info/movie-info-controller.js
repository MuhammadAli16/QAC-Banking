(function() {

    var MovieInfoController =  function($state, movieDal)
    {
        var vm = this;

        function init() {
            var movieId = $state.params.obj.id;
        		movieDal.getMovie(movieId).then(function (results) {
        			console.log("test");
        			console.log(JSON.stringify(results));
                vm.movie  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };
    angular.module('cinema').controller('movieInfoController', ['$state', 'movieDal', MovieInfoController]);
}());