var BasicModule=angular.module('BasicModule',[]);

BasicModule.service('BasicService',['$http','$q','REST_URI',function($http,$q,REST_URI){
this.getGreeting=function()
{

    var deffered=$q.defer();
    $http.get(REST_URI +'/greeting')
    .then(

        //success callback function
        function(response)
        {
            deffered.resolve(response.data.responseMessage);
        },

        //error callback
        function(error)
        {
            deffered.reject(error);
        }
    );
    return deffered.promise;
}

}]);