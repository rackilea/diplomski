function getXMLObject()  //XML OBJECT
        {
            var xmlHttp = false;
            try {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
            }
            catch (e) {
                try {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
                }
                catch (e2) {
                    xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
                }
            }
            if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
                xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
            }
            return xmlHttp;  // Mandatory Statement returning the ajax object created
        }
    var xmlhttp = new getXMLObject();   //xmlhttp holds the ajax object
        function ajaxFunction() {
            if(xmlhttp) {
                xmlhttp.open("GET","NameList",true); //NameList will be the servlet name
                xmlhttp.onreadystatechange  = handleServerResponse;

                xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xmlhttp.send(null);
            }
        }
        function handleServerResponse() {
            if (xmlhttp.readyState == 4) {
                if(xmlhttp.status == 200) {
                   getVal();
                }
                else {
                    alert("Error during AJAX call. Please try again");
                }
            }
        }
       function getVal()
        {
             var xmlResp=xmlhttp.responseText;
             try{

                if(xmlResp.search("Maintag")>0 )
                {
               var x=xmlhttp.responseXML.documentElement.getElementsByTagName("Subtag");
                    var xx=x[0].getElementsByTagName("unameVal"); 
                    var recievedUname=xx[0].firstChild.nodeValue;
                   document.getElementById("message").innerText=recievedUname;//here 
                } 
                }catch(err2){
                    alert("Error in getting data"+err2);
                }
        }