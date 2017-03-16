window.routes={
"/home":{
templateUrl:'app/components/basic/Home.html',
controller:'BasicController',
controllerAs:'basicCtrl',
requireLogin:false,
roles:['GUEST','ADMIN','STAFF','STUDENT']

},

"/about":{
templateUrl:'app/components/basic/about.html',
controller:'BasicController',
controllerAs:'basicCtrl',
requireLogin:false,
roles:['GUEST','ADMIN','STAFF','STUDENT']
},

"/login":{
templateUrl:'app/components/authentication/Login.html',
controller:'AuthenticationController',
controllerAs:'authCtrl',
requireLogin:false,
roles:['GUEST','ADMIN','STAFF','STUDENT']
}
};

//specify the backend url from where you are going to get the values
app.constant('REST_URI','http://localhost:8080/onlinecollaboration');

app.config(['$routeprovider',function($routeprovider)
{
for(var path in window.routes)
{
    $routeprovider.when(path,window.routes[path]);

}
$routeprovider.otherwise({redirectTo:'/login'});
}]);