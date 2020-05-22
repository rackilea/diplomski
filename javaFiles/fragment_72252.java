<script>
var myObject=JSON.parse(dataVO.adScript); 
var index;
for (index = 0; index < myObject.length; ++index) {

     alert("Test Latitude "+myObject[index].latitude);

     alert("Test Longitude "+myObject[index].longitude);

}
</script>