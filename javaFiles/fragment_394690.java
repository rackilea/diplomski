<th:block th:fragment="myMaps(target, longitude, latitude, zoom)">
    <div th:id="${target}" class="map"></div>

    <script th:inline="javascript">
        var map = new ol.Map({
            target: [[${target}]],
            layers: [
              new ol.layer.Tile({
                source: new ol.source.OSM()
              })
            ],
            view: new ol.View({
              center: ol.proj.fromLonLat([
                  [[${longitude}]], 
                  [[${latitude}]]
              ]),
              zoom: [[${zoom}]]
            })
          });
      </script>
</th:block>