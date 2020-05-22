$(document).ready(function() {
$('#myForm').submit(function (ev) {
    ev.preventDefault(); // prevent default action witch is form-submit
    var form = this; // avoid using jQuery's selection. 
    console.log(1);
    var year = $('#year').val();
    var month = $('#month').val();
    console.log(year);
    console.log(month);
    $.ajax({
        type: "GET",
        url: 'ActionServlet',
        data: "year=" + year + "&month=" + month,
        success: function (data) {
          console.log(data);
          $('#ajaxDiv').text(data);
          var result= parseInt(data, 10);
          if (result > 0) {
                if(confirm("you sure about that?")){ //if yes is clicked (negation is removed) 
                    form.submit(); // this won't trigger the jQuery's submission, so it will not cause infinite loop.
                }
          }
        },error : function(e) {
            alert('Error: ' + e); 
        }
    });  
});
});