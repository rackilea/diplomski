import org.brotli.dec.BrotliInputStream;

if(response.getLastHeader("content-encoding").getValue().equals("br")) { // check if getting brotli compressed stream
    rd = new BufferedReader(new InputStreamReader(new BrotliInputStream(response.getEntity().getContent())));
}
else {
    rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
}