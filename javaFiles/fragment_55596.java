$.ajax({
url:"myURL",
type:"GET",
success:function(msg){
    DateJson = msg;
},
dataType:"json"
});