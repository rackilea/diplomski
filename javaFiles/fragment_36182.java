$("#loginBtn").click(function() { 
     $.post('http://localhost:8080/NewDesignV1/login.action',
        {
            username : $("#username").val(),
            password : $("#password").val()

        },
        function(data){
           console.log(data);//you can get the redirect jsp context
        },
        ,'html');
});