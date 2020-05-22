<%  
  String[] array=["books","pens","cars"];
  String array_joined = '"' + array[0] + '"';
  for (int i=1; i<array.length; i++) array_joined += ',' + '"' + array[i] + '"';
  array_joined = '[' + array_joined + '];';
%>

<script>
     var javaArray= <%= array_joined %> // renders ["books","pens","cars"];

     var tempArrayValue = [];

     function myFunction(){

     for(var i=0,j=0;i<javaArray.length;i++,j++){

     tempArrayValue[j]=javaArray[i]; //trying to store ["books","pens","cars"] values into "tempArrayValue"

     }

  }

</script>