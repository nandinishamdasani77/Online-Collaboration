BasicModule.controller('BasicController',['BasicService',$scope,function(BasicService,$scope)
{
    var me=this;

    
//me.greeting='This message is coming from angular controller';


BasicService.getGreeing().then(
    function(greeting){
        me.greeting=greeting;
    },

    function(error)
    {
        console.log(error);
    }
)
}
]);