<script>
    $(document).ready(function(){
      $("#country_id").change(function() {
         //var xyz = $("option:selected").val();
         var xyz = $(this).val();

         alert(xyz);

         $.get("../Retrive_country?stateadd_1=none", { countryREF: xyz }, function(data,status){
           alert("Data: " + data + "\nStatus: " + status);
         });

      });
    });
</script>