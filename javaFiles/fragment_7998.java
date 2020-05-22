<script>
    $(document).ready(function(){
      $('input[name=players]').change(function() { 
       //alert('hello');
       var checkedNum = $('input[name="players[]"]:checked').length;
       if (!checkedNum) {
        // User didn't check any checkboxes
        disableBtn();
       }  
      });
    });
</script>