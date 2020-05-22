$.ajax({
        url:'anki',
        type:'POST',
        data:JSON.stringify(eval({"name":"me"})),
        dataType: 'json',
        contentType: 'application/json',    
        success:function(data){
        alert('here gain');

       //  $('#time').html(data.name);


    }
    });