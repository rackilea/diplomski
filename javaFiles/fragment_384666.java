function myAjaxRequest()
{
var xmlhttp; /*our ajax object*/

        if (window.XMLHttpRequest)
          {// code for IE7+, Firefox, Chrome, Opera, Safari
          xmlhttp=new XMLHttpRequest();
          }
        else
          {// code for IE6, IE5
          xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
          }
        setVisible('loading', true) ;

        /*this function called when ajax state changes*/
        xmlhttp.onreadystatechange=function()
          {
          /*when the query has completed successfully*/
          if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                /*now you can do what you want with your response text!*/
                var mystring= xmlhttp.responseText;
                alert(mystring);
            }

          }

        /*the URL query we want to run*/
        var query = "RunQuery?foo="+$('#txtFoo').val();
        alert(query);

        /*AJAX object runs the query*/
        xmlhttp.open("GET", query, true); 
        xmlhttp.send();     
}