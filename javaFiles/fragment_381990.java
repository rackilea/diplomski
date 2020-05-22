import java.util.Collections;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.collections.Collection;

import com.flickr4java.flickr.test.TestInterface;

public class hello {
    public static void main(String args[]){


    String apiKey = "3f7046fe0897516df587cc3e6226f878";
    String sharedSecret = "9d0ceef5f2f3040f";
    Flickr f = new Flickr(apiKey, sharedSecret, new REST());
    TestInterface testInterface = f.getTestInterface();
    java.util.Collection<Element> results = testInterface.echo(Collections.EMPTY_MAP);

    }
}