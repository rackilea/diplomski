<%
    Reader reader = new FileReader("c:/path/to/external/file.html");
    try {
        for (int i = 0; (i = reader.read()) != -1;) {
            out.write(i);
        }
    } finally {
        try { reader.close(); } catch (IOException ignore) {}
    }
%>