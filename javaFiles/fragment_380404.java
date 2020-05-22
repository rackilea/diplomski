<string name="html_streetview">    <![CDATA[
<html>
<head>
   <script src="http://maps.google.com/maps/api/js?v=3&amp;sensor=false" type="text/javascript"></script>
 </head>
<body>
<script type="text/javascript">
 Android.echo();
 var testPoint = new google.maps.LatLng(%1$s, %2$s,true);
 var svClient = new google.maps.StreetViewService();
 svClient.getPanoramaByLocation(testPoint, 50,function (panoramaData, status) {
   if (status == google.maps.StreetViewStatus.OK) {
     Android.hasStreetview();
   } else {
     Android.hasNotStreetview();
   }
 });
</script>
</body>
</html>
]]>
</string>