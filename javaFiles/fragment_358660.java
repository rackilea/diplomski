function getURLParameters() {
  var keyValuePairs = location.search.split(/[&?]/g);
  var params = {};
  for (var i = 0, n = keyValuePairs.length; i < n; ++i) {
    var keyValuePair = keyValuePairs[i];
    var eqIndex = keyValuePair.indexOf("=");
    if (eqIndex >= 0) {
      params[decodeURIComponent(keyValuePair.substring(0, eqIndex))]
        = decodeURIComponent(keyValuePair.substring(eqIndex + 1));
    }
  }
  return params;
}