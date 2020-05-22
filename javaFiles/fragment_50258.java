success: function (data) { 
        /* because you set the content-type header as 'application/json', you'll receive an already parsed javascript object - don't need to use JSON.parse. */


        console.log(data);
        /*
            {
                firstname: "first name from db",
                telephone: "telephone from db"
            }

        */

        alert(data.firstname); //alert firstname
        alert(data.telephone); //alert phone
   }