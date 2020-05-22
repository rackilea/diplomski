JspFragment body = getJspBody(); 
StringWriter stringWriter = new StringWriter(); 
StringBuffer buff = stringWriter.getBuffer(); 
buff.append("<h1>"); 
body.invoke(stringWriter); 
buff.append("</h1>"); 
out.println(stringWriter);