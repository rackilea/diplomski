url: 'http://server_ip:8080/backend/authenticate',


       jsonData : param,


    success: function(response){
      Ext.Msg.Alert(null,"Login Successfule");
      //You can write your own logic to display any other screen
    }



    failure : function(error){
      Ext.Msg.Alert(null,"Unable to authenticate user");
    }