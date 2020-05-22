public class MyDataSource implements DataSource {
    public InputStream getInputStream() throws IOException {

        //return inputStream;
InputStream inputStream= new FileInputStream(file);
return inputStream;
    }
}