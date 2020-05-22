contract = {fromDate:moment($('#datepickerVon').val(), 'DD-MM-YYYY').format('DD-MM-YYYY'), endDate:moment($('#datepickerVon').val(), 'DD-MM-YYYY').format('DD-MM-YYYY'), Season: {
          season: "SO14"}, name: {name: "peter"}, category:{category:"SomeString"}};

          console.log(contract);
      $.ajax({
          url:'/contracts/search/',
          dataType: "json",
          type: "POST",
          mimeType: 'application/json',
          contentType: "application/json",
          data: JSON.stringify(contract),
          success: function(data) {
              console.log(data);
          }
          });