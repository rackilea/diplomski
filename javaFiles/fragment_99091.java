import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import android.os.Environment;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import android.content.Context;

        try {
        FileInputStream fis;
        ArrayList<String> ad;
        ArrayList<String> phone_no;

        ad = new ArrayList<String>();
        phone_no = new ArrayList<String>();

        // temp holder for current text value while parsing
        String curText = "";
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

        XmlPullParser xpp = factory.newPullParser();
        // Open up InputStream and Reader of our file.
        fis =  new FileInputStream(new File("/sdcard/TELEFON_YEDEK/yedek.xml"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        // point the parser to our file.

        xpp.setInput(reader);
        // get initial eventType

        int eventType = xpp.getEventType();
        // Loop through pull events until we reach END_DOCUMENT

        while (eventType != XmlPullParser.END_DOCUMENT) {

            // Get the current tag

            String tagname = xpp.getName();
            // React to different event types appropriately

            switch (eventType) {

            case XmlPullParser.TEXT:
                //grab the current text so we can use it in END_TAG event
                curText = xpp.getText();
                break;
            case XmlPullParser.END_TAG:
                if (tagname.equalsIgnoreCase("adSoyad")) {
                    // if </adSoyad> add on adSoyad
                    ad.add(curText);
                } else if (tagname.equals("telefon")) {
                    // if </telefon> use setLink() on telefon
                    phone_no.add(curText);
                }
                break;
            default:
                break;
            }
            //move on to next iteration
            eventType = xpp.next();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    try {
        fis.close();
    }catch(Exception e){
        Log.i("Problem closing", "Closing fis");
    }