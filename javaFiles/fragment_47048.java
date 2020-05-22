function validate() {
    var idField = document.getElementById("name1");
    var data = "name1=" + encodeURIComponent(idField.value);
    if (typeof XMLHttpRequest != "undefined") {
        req = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    var url = "Validator"
    req.open("GET", url, true);
    req.onreadystatechange = inserter
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send(data);
}


function inserter() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var msg1 = req.responseText
            if (msg1 == "") {
                document.getElementById("msg").innerHTML = "<div style=\"color:red\">Wadliwa nazwa</div>";
                document.getElementById("org").value = '';
            } else {
                document.getElementById("org").value = msg1;
            }
        }
    }
}