function loadJSON(itemName) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById(itemName).value = this.responseText
    }
  };
  xhttp.open("GET", "{PATH}", true);
  xhttp.send();
}
loadJSON("P1_USER_INFO");