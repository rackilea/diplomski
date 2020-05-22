package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Convert {

    private static final int LINES_PER_ELEMENT = 4;
    private static final int COUNT_OF_ELEMENTS = 2;
    private static final int ID_INDEX = 0;

    public static List<String> getFile() {
        List<String> list = new ArrayList<String>();
        File file = new File("text");
        BufferedReader br = null;
        try {
            InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in);
            br = new BufferedReader(reader);
            String line = null;
            while((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static Document getXml(List<String> lines) {
        Element root = DocumentHelper.createElement("root");
        Document document = DocumentHelper.createDocument(root);
        String[][] strArr = new String[COUNT_OF_ELEMENTS][LINES_PER_ELEMENT];
        for(int i = 0;i < COUNT_OF_ELEMENTS;i++) {
            for(int j = 0;j < LINES_PER_ELEMENT;j++) {
                strArr[i][j] = lines.get((i + 1) * (j + 1) - 1);
            }
        }

        for(int i = 0;i < COUNT_OF_ELEMENTS;i++) {
            Element itemBonusDefinition = root.addElement("ItemBonusDefinition");
            String[] elemValues = strArr[i];
            Element id = itemBonusDefinition.addElement("id");
            Element bonus = itemBonusDefinition.addElement("bonus");
            for(int j = 0;j < elemValues.length;j++) {
                if(j == ID_INDEX) {
                    id.setText(elemValues[j]);
                } else {
                    Element shorT = bonus.addElement("short");
                    shorT.setText(elemValues[j]);
                }
            }
        }
        return document;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = getFile();
        Document document = getXml(lines);
        OutputStream out = new FileOutputStream("C:\\Users\\admin\\Desktop\\test11.xml");
        Writer wr = new OutputStreamWriter(out);
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(wr,format);
        writer.write(document);
        writer.close();
    }
}