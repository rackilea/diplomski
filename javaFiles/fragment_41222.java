public String loadResource(String filelocation) {
    if (filelocation != null && !filelocation.trim().isEmpty()) {
        try (
            InputStream inputStream = getClass().getResourceAsStream(filelocation);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {

            String fileLine = "";
            StringBuffer stringBuffer = new StringBuffer();

            while((fileLine = bufferedReader.readLine())!= null){
                stringBuffer.append(fileLine);
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return null;
}