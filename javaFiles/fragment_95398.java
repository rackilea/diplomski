<script>
    $('#map').ready(function(){
      #{list items: all, as:'object'}
      addMarkerFromRendered("${object.name}", "${object.lat}", "${object.lng}", "${object.type}", "${object.description}", "/public/img/${object.type}.png");
        #{/list}
      });
  </script>