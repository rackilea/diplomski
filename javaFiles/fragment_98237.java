<div id = "selectedCampaigns" onchange="loadAdSets()">
  <form:checkboxes path="selectedCampaigns"  multiple="true" items="${campaigns}" delimiter="<br/>"/>
  <script type="text/javascript">
    dojo.query("#selectedCampaigns label").forEach(function(element) {
      dojo.setAttr(element,"title",element.innerHTML);
    });
  </script>
</div>