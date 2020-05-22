onload : function(e){
    var result = JSON.parse(this.responseText);
    alert(result.message);
    alert(result.action);
    alert(result.extra);
},