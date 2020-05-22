public class ConvertibleOutputStream extends ByteArrayOutputStream {
    //Craetes InputStream without actually copying the buffer and using up mem for that.
    public InputStream toInputStream(){
        return new ByteArrayInputStream(buf, 0, count);
    }
}