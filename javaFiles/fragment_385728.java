$('#form1').on('submit', function(e) { 
    $form = $(this);
    $.post($form.attr('action'), $form.serialize(), function(responseText) { 
        $('#processing2').fadeOut();
        $('#frm').attr('src', 'theServlet?x=' + $('#x').val() + '&y=' + $('#y').val());                                    
    });
    return false;  
});