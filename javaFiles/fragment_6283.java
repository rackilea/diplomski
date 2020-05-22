java_set_file_encoding("ISO-8859-1");

  $em = java('net.sf.jasperreports.engine.JasperExportManager');
  $result = $em->exportReportToPdf($pm);

  header('Content-Length: ' . strlen( $result ) );

  echo $result;