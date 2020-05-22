dataType: "json";           //this line should not be here
alert(responseJson);
//var result = $.parseJSON(responseJson); <-- this line fails
$('#question1').val(responseJson[0]);
$('#question2').val(responseJson[1]);
$('#question3').val(responseJson[2]);