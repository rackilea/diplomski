// process the data (In your case go get it)
byte[] data = generateReturnBuffer();
// do not cache
response.setHeader("Expires", "0");  
response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");  
response.setHeader("Pragma", "public");
// content length is needed for MSIE
response.setContentLength(data.length);
// set the filename and the type
response.setContentType("application/pdf");  
response.addHeader("Content-Disposition", "attachment;filename=" + "fileName.pdf");  
ServletOutputStream out = resp.getOutputStream();
out.write(data);
out.flush();