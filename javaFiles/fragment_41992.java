<script>
$(document).ready(function(){
    console.log("ready is called");
    //PF('statusDialog').hide()
    $('#nonAjaxLoad').hide();
});

$(window).bind('beforeunload', function() {
     console.log("bind is called");
    // PF('statusDialog').show()
    $('#nonAjaxLoad').show(); 
});
</script>