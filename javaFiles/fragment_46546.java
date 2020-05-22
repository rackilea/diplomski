enter code herepackage com.stackoverflow.test.xstream_xml_to_map;

import java.io.File;

import com.thoughtworks.xstream.XStream;

public class App {

public static void main(String[] args) {
    XStream xStream = new XStream();
    File f = new File(App.class.getClassLoader().getResource("provided.xml").getFile());
    xStream.alias("Response", Response.class);
    Response res = (Response) xStream.fromXML(f);
    System.out.println("Credit: "+res.getCredit());
    System.out.println("Status: "+res.getStatus());
}
}