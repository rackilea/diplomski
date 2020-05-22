$(document).ready(function(){

      $("#startDate").datepicker({

          dateFormat: 'dd.mm.yy',

          numberOfMonths: 1,

          onSelect: function(selected) {

            $("#endDate").datepicker("option","minDate", selected);

          }

      });

      $("#endDate").datepicker({

          dateFormat: 'dd.mm.yy',

          numberOfMonths: 1,

          onSelect: function(selected) {

              $("#startDate").datepicker("option","maxDate", selected);

          }

      }); 

    });