$(function () {
    function callServlet() {
        var input1 = $("#number1").val(); //document.getElementById('number1').value;
        var input2 = $("#number2").val(); //document.getElementById('number2').value;
        var myData = {
            "mydata": {
                "number1": input1,
                "number2": input2
            }
        };
        //console.log(myData);
        $.ajax({
            type: "GET",
            url: 'http://www.mocky.io/v2/547f86501713955b0a8ed4da',  //"/AjaxServletCalculator",
            data: {
                //jsonData: JSON.stringify(myData) // this works but mocky.io doesn't support it
            },
            dataType: "json",

            //if received a response from the server
            success: function (json) {
                //our country code was correct so we have some information to display
                console.log(json);
                //var json = JSON.parse(data);
                alert(json.data);
                /*document.getElementById('number1').value = data.*/
            }
        });
    }
    
    $('#calcBtn').click(function() {
        callServlet();
    });
});