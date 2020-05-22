<script>
$(document).ready(function(){
$("#country_id").change(function() {
   var xyz = $("option:selected").val();
 var Myselect = $('#state_ref');
$.getJSON("../Retrive_country?stateadd_1=none",
    {countryREF : xyz } ,function(data){

     console.log(data);
   $('#state_ref').empty();
       $.each(data, function(index, state){
          for(var prop in state.stateidlist){
              var stateidvalue = state.stateidlist[prop];
              var statelistvalue = state.statelist[prop];
              $("<option></option>")
                .attr("value", stateidvalue).text(statelistvalue)
                .appendTo('#state_ref');

              }

       });   
 });//end get          
   });
});

</script>