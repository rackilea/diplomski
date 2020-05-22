<script>
    $( "select" ).change(function () {
        var str = "";
        $( "select option:selected" ).each(function() {
            str = $( this ).text();
        });
        if(str == "input")
            $( "div" ).append("<input type='text' name='textbox1' value='' />");
        else if(str == "textarea")
            $( "div" ).append("<input type='textarea' name='textarea1' value='' />");
        // ...
    })
    .change();
</script>