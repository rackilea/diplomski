function getCauses() {

  var causes = new Array();
  if ($("#game-type").val() == "basketball") {

     $.ajax({
        url:'basketball.txt',
        async: false, // try this
        success:function (data) {
          //split on new lines
          causes = data.split('\n');
          console.log(causes);
        }
     });

     console.log("second: " + causes);
   }

   var c = "<option></option>";
   for (var i = 0; i < causes.length; i++) {
      c += "<option value='" + causes[i] + "'>" + causes[i] + "</option>";
   }
   return c;
}