<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/jtable.css" type="text/css">        
        <link rel="stylesheet" href="resources/css/style.css" type="text/css">
        <link rel="stylesheet" href="resources/css/jquery-ui-1.10.3.custom.css" type="text/css">
        <link href="resources/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" /> 
        <script src="resources/js/jquery-1.11.3.js" type="text/javascript"></script>
        <script src="resources/js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
        <script src="resources/js/recuperacion-datos.js" type="text/javascript"></script>        
        <title></title>
        <script>
            $(document).ready(function(){
                $("#datepicker1").datepicker({
                    maxDate: 0
                });
                $("#datepicker2").datepicker({ 
                    maxDate: 0,
                    onSelect: function(selected) {
                       $("#datepicker1").datepicker("option","maxDate", selected);
                    }
                });
            });
        </script>       
    </head>
    <body>
    <center>
        <div class="jtable-main-container" style="width: 60%;">
            <div class="jtable-title">
                <div class="jtable-title-text">
                    Recuperaci&oacute;n de Datos
                </div>
            </div>
            <div style="position: relative; text-align: center; font-size: 17px; top: 10px;">
                <s:form theme="simple" action="GetRecovery" method="POST" id="LecturasTableContainer">          
                    Fecha Inicio: <input type="text" name="fechaInicio" id="datepicker1">
                    <span>&nbsp;</span><span>&nbsp;</span>
                    Fecha Fin: <input type="text" name="fechaFin" id="datepicker2">
                    <s:submit value="Descargar" id="LoadRecordsButton" type="button"/>
                </s:form>
            </div>
        </div>      
    </center>
    </body>
</html>