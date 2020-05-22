<script>
    jQuery(function($){
    $(".date").mask("99/99/9999");
    $(".time").mask("99:99");
    });



if (document.getElementById('form:d').value == 'Date' ||     document.getElementById('form:d').value == '') {
        document.getElementById('form:d').value = 'Date';
    }
    if (document.getElementById('form:t').value == 'Time' || document.getElementById('form:t').value == '') {
        document.getElementById('form:t').value = 'Time';
    }

</script>