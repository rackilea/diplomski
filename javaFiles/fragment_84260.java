import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

public abstract class File implements Iterable<String>{
    public final static String READ = "r";
    public final static String WRITE = "w";

    public static File open(String filepath) throws IOException{
        return open(filepath, READ);
    }   

    public static File open(String filepath, String mode) throws IOException{
    if(mode == READ){
        return new ReadableFile(filepath);
    }else if(mode == WRITE){
        return new WritableFile(filepath);
    }
    throw new IllegalArgumentException("Invalid File Write mode '" + mode + "'");
    }

    //common methods
    public abstract void close() throws IOException;

    // writer specific
    public abstract void write(String s) throws IOException;

}

class WritableFile extends File{
    String filepath;
    Writer writer;

    public WritableFile(String filepath){
        this.filepath = filepath;
    }

    private Writer writer() throws IOException{
        if(this.writer == null){
            writer = new BufferedWriter(new FileWriter(this.filepath));
        }
        return writer;
    }

    public void write(String chars) throws IOException{
        writer().write(chars);
    }

    public void close() throws IOException{
        writer().close();
    }

    @Override
    public Iterator<String> iterator() {        
        return null;
    }
}

class ReadableFile extends File implements Iterator<String>{
    private BufferedReader reader;
    private String line;    
    private String read_ahead;

    public ReadableFile(String filepath) throws IOException{        
        this.reader = new BufferedReader(new FileReader(filepath)); 
        this.read_ahead = this.reader.readLine();
    }

    private Reader reader() throws IOException{
         if(reader == null){
               reader = new BufferedReader(new FileReader(filepath));   
         }
         return reader;
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }

    @Override
    public void close() throws IOException {
        reader().close();
    }

    @Override
    public void write(String s) throws IOException {
        throw new IOException("Cannot write to a read-only file.");
    }

    @Override
    public boolean hasNext() {      
        return this.read_ahead != null;
    }

    @Override
    public String next() {
        if(read_ahead == null)
            line = null;
        else
            line = new String(this.read_ahead);

        try {
            read_ahead = this.reader.readLine();
        } catch (IOException e) {
            read_ahead = null;
            reader.close()
        }
        return line;
    }

    @Override
    public void remove() {
        // do nothing       
    }
}