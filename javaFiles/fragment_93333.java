import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class trans {

    public static void main(String[] args) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsl = new StreamSource("input.xsl");
        Transformer transformer = factory.newTransformer(xsl);
        Source xml = new StreamSource("data.xml");
        Result result = new StreamResult("out.xml");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input min salary:");
        String minSalary = reader.readLine();
        transformer.setParameter("MinSalary", minSalary);
        transformer.transform(xml, result);


    }
}