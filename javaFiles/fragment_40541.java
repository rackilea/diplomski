<script>
$(document).ready(function() {
    $("#test").change(function() {
       var selectedValue = $("#test").val();
       if (selectedValue == "1") {
          $("#field").val("First option selected");
       } else {
          $("#field").val("Second option selected");
       }
    }
    });
});
</script>