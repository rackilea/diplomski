import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Main {

    public static void main(String[] args) throws JAXBException {
        Feed feed = (Feed) JAXBContext
                .newInstance(Feed.class)
                .createUnmarshaller()
                .unmarshal(new File("youtube_feed.xml"));

        for (Entry entry : feed.getEntries()) {
            System.out.println(entry.toString());
        }

    }
}