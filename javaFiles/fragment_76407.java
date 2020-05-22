$(function () {
            var today = new Date();
            var thisYear = (today).getFullYear();
            var fromDate = '1/1/2000'   //this is the initial from date to set the datepicker range
            var toDate = '1/7/2000' // this is the initial to date to set the datepicker range

//... initialize datepicker....
  },
  beforeShowDay: function(date){
        //if the date is in range
        if (date >= fromDate && date <= toDate) { 
           return [true, 'ui-individual-date', '']; //applies a css class to the range
         }
         else {
            return [true, '', ''];
          }
    },
   onSelect: function (dateText, obj) {

//sets the new range to be loaded on refresh call, assumes last click is the toDate              
     fromDate = toDate; 
     toDate = new Date(dateText); 

    $(".classDp1").datepicker("refresh"); 
    $(".classDp2").datepicker("refresh"); 
  },