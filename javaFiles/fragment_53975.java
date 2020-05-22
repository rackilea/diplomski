$("#button-id").click(function() {
    $.ajax({
        url: "/url?topic="+$('#topic').val()+'&Nopages='+$('#Nopages').val()+'&link='+$('#link').val()+'&range='+$('#range').val(),
    })
    .done(function( data ) {
        // Invoke your function here
        validate();
    });
});