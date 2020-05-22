<script>
    var errors = $('#error-noty');
    if(errors.html()) {
        noty({text: errors.html()});
    }
</script>