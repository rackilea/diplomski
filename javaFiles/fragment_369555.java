<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MedAI - Medical Artifical Intelligence</title>
        <script type="text/javascript" src="resources/js/jquery.js"></script>     
        <script type="text/javascript" src="resources/js/jquery-ui.js"></script>  
</script>        
        <link href="resources/css/jquery-ui.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/medai.css" rel="stylesheet"  type="text/css" />
    </head>
    <body>
    <div class="header">
        <h1>MedAI</h1>
        <span class="version">V 1.0.0</span>            
    </div>

    <div id="tabs">
    <ul>
        <li><a href="home.htm">Home</a></li>
        <li><a href="GeneNetwork.htm">Gene Network</a></li>
        <li><a href="DiseaseNetwork.htm">Disease Network</a></li>
    </ul>  
    </div>
        <script type="text/javascript">
            $(document).ready(function() {
            $('#tabs')
                .tabs()
            });    
        </script>    
    </body>
</html>