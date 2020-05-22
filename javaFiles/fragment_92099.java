xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4) {
      // handle response
      var response = JSON.parse(xhttp.responseText);
      console.log(response);
      if (response.toString() == "hej") {
        var url = "http://localhost:8080/FM3/spil2.jsp";
        window.location.href = url
      }
    }
  }

  xhr.send();