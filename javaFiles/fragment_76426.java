import org.apache.avro.*;
import org.apache.avro.generic.*;
import org.apache.avro.file.*;
import org.apache.avro.io.*;

public class AvrotoTextFormatter

{

public static void main ( String args[]) throws Exception

{

    InputStream in = null;
    in = new FileInputStream(args[0]);
    BufferedReader br;
    BufferedInputStream inStream = new BufferedInputStream(in);
    PrintWriter pr1 = new PrintWriter(args[1], "UTF-8");
    PrintWriter pr = new PrintWriter(args[2], "UTF-8");
    StringTokenizer st;
    StringTokenizer st1;
    int row_counter = 0;
    String header_fields = "";
    String content_records = "";
    String sCurrentLine = "";


    GenericDatumReader<Object> reader = new GenericDatumReader<Object>();
    DataFileStream<Object> fileReader = new DataFileStream<Object>(inStream, reader);



    pr1.println(fileReader.getSchema().getFields());

    pr1.close();

    br = new BufferedReader(new java.io.FileReader(args[1]));


    while ((sCurrentLine = br.readLine()) != null)
    {
    st = new StringTokenizer(sCurrentLine," ");
    while (st.hasMoreTokens())
    {
        header_fields = header_fields + st.nextToken() + "|";
        st.nextToken();
        st.nextToken();             
    }        
    }
    header_fields = header_fields.substring(1,header_fields.length()-1); 
    pr.println(header_fields);


    File file = new File(args[0]);
    DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(fileReader.getSchema());
    DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);
    GenericRecord user = null;
        while (dataFileReader.hasNext())
           {
              content_records = "";
              user = dataFileReader.next(user);
              st1 = new StringTokenizer(header_fields,"|");
              while (st1.hasMoreTokens())
            {
                content_records = content_records + user.get(st1.nextToken()) + "|";              
                }
    content_records = content_records.substring(0,content_records.length()-1);
    pr.println(content_records); 
            } 
    fileReader.close();
    br.close();
    pr.close();  

}

}