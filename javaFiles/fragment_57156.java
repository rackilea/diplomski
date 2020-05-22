/* alert("inside ajax"); */
    $.ajax({
        url : 'profile.html',
        data : data,
        success : function(data) {/* alert(data); */
            if(data=='Give the Different Reg number'){
                $('#regnum').val('');
                }  
       else {
             $('#result').html(data);
            }
        }
    });