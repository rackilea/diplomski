$.get('excelCreaterServlet', 
          {name: $('#test').val()}, 
          function (response) 
          {
              console.log(response);
              window.open("excelCreaterServlet");
          });