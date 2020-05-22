<script>
    var selections = "${sessionScope.csv}".split(",");
    for ( var v = 0; v < selections.length; v++) {
        alert(selections[v]);
    }
</script>