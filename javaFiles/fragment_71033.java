checkboxes.on('click', function(event) {
    if($(this).prop('checked')){
        btn.removeAttr('disabled');
        $('form').append('<input type="hidden" name="fieldname" value="'+this.value+'" />');
    } else {
        btn.attr("disabled",!checkboxes.is(":checked"));
    }
});