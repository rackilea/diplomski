/**
 * The format of the report. (supports 'html' or 'xml'. defaults to 'html')
 * 
 * @parameter expression="${cobertura.report.format}"
 * @deprecated
 */
private String format;

/**
 * The format of the report. (can be 'html' and/or 'xml'. defaults to 'html')
 * 
 * @parameter
 */
private String[] formats = new String[] { "html" };