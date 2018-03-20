(function() {

    var DashBoardController =  function()
    {
        var vm = this;

        vm.test = "test";
    };
    angular.module('bank').controller('dashboardController', [DashBoardController]);
}());