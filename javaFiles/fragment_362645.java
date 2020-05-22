function sendRequest(){
var str = "this is string";
    $.ajax({
            url:"ajaxtest",
            type:"POST",
            //data:JSON.stringify(myJson).toString(),
            data:{myStr:str},
            success: alert("good")
        });}