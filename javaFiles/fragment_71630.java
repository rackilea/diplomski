JRHtmlExporter exporter = new JRHtmlExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, 
    "<html>"+
    "<head>"+
    "  <title></title>"+
    "  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>"+
    "  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/jasper.css\" />"+
    "  <style type="text/css">"+
    "    a {text-decoration: none}"+
    "  </style>"+
    "</head>"+
    "<body text="#000000" link="#000000" alink="#000000" vlink="#000000">"+
    "<table width="100%" cellpadding="0" cellspacing="0" border="0">"+
    "<tr><td width="50%">&nbsp;</td><td align="center">");
exporter.exportReport();