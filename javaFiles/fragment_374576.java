<html>

<head>
  <script language="JavaScript">
    var x = [];
    var y = [];

    function point_it(event) {
      pos_x = event.offsetX ? (event.offsetX) : event.pageX - document.getElementById("pointer_div").offsetLeft;
      pos_y = event.offsetY ? (event.offsetY) : event.pageY - document.getElementById("pointer_div").offsetTop;
      document.getElementById("cross").style.left = (pos_x - 1);
      document.getElementById("cross").style.top = (pos_y - 15);
      document.getElementById("cross").style.visibility = "visible";
      x.push(pos_x);
      y.push(pos_y);
      document.getElementById("form_x").innerHTML = x;
      document.getElementById("form_y").innerHTML = y;
    };

    function remove_it() {
      x.pop();
      y.pop();
      document.getElementById("form_x").innerHTML = x;
      document.getElementById("form_y").innerHTML = y;
    }
  </script>
</head>

<body>
  <form name="pointform" method="post">
    <div id="pointer_div" onclick="point_it(event)" style="background-image:url('image.jpg');width:2400px;height:1848px;">
      <img src="point.gif" id="cross" style="position:relative;visibility:hidden;z-index:2;">
    </div>
    You pointed on
    <br>x = <span id="form_x"></span> 
    <br>y = <span id="form_y"></span>
    <br>
    <button onclick="remove_it()">remove last</button>
  </form>
</body>

</html>