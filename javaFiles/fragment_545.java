}).done(function( data) {
        //some processing for display
        var len = data.length
        for (var i=0; i<len; ++i) {
               var employeeFirstName =  data[i].firstName;
               var employeeLastName =  data[i].lastName;
               //set it to some DIV, or do the processing you want
        }
      }

    });