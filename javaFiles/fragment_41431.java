window.onload = function() {

var applet = document.getElementById("header");
    applet.onmouseover = function(e) {
         window.onscroll = function(e) {
         //scroll where you want to be (the top)
           scroll(0,0) ;
         }
     }

    applet.onmouseout = function(e) {
          //replace with empty function
          window.onscroll = function(e) {}
    }

};