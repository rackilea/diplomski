success: function (data) {
    for (var i = 0; i < data[0].length; i++) {  // access the first item data[0] of outer array
         var item = data[0][i];                 // and get the nth object
         $('#applicationList > tbody').append(
            // code skipped
         );
         insideData(data);
    }
},