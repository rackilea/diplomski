OutputStream out=connection.getOutputStream();
try {
    jsonParser.writeValue(out,dto);
    out.flush();
//catch and handle the exceptions if needed
} finally {
    out.close();
}