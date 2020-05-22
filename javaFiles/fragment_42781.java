<script>
       function ajax_login(u) {         
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                alert(xmlhttp.responseText);//to check whether the response is coming or not
                document.getElementById("forgot").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET","control.jsp?uid="+u+"&pwd="+document.getElementById("password").value,true);
        xmlhttp.send();
    }
    </script>


   <input type="password" value="some" id="pass" name="pwd"/>
   <button id="empid" value='emp001' onclick='ajax_login(this.value);'>Login</button>