(function() {

    var GetAccountController =  function($state, movieDal)
    {
        var vm = this;
        vm.test = "test";
        
        vm.info = function(movie)
        {
        		$state.go("movieinfo", {obj: movie});
        };
        
        vm.delete = function (movieToDelete) {
            var waitingDialog;
            BootstrapDialog.confirm({
                message: 'Are you sure that you want to delete this movie?',
                type: BootstrapDialog.TYPE_DEFAULT,
                btnOKLabel: 'Delete',
                btnOKClass: 'btn-default',
                callback: function (confirmed) {
                    if (confirmed) {
                        waitingDialog = BootstrapDialog.show({
                            message: 'Please wait - Deleting movie'
                        });
                        movieDal.deleteMovie(movieToDelete).then(function () {
                            waitingDialog.close();
                            init();
                        }, function (error) {
                           console.log("The movie has not been deleted there has been an error");
                        });
                    }
                }
            })
        };


        function init() {
            movieDal.getMovies().then(function (results) {
                vm.movies  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };
    angular.module('bank').controller('getAccountController', ['$state', 'movieDal', GetAccountController]);
}());