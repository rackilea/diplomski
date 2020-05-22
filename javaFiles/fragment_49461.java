import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

public class FileActivity extends Activity {


    // Progress dialog
    ProgressDialog pDialog;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        String data = "<tns:camera>"
            +"  <tns:congestionLocations>"
            +"<tns:congestion>Free Flow</tns:congestion>"
        +"<tns:direction>Eastbound</tns:direction>"
        +"</tns:congestionLocations>"
        +"<tns:congestionLocations>"
        +"<tns:congestion>Free Flow</tns:congestion>"
        +"<tns:direction>Westbound</tns:direction>"
        +"</tns:congestionLocations>"
        +"<tns:description>Bond St looking east</tns:description>"
        +"<tns:direction>Eastbound</tns:direction>"
        +"<tns:group>SH16-North-Western</tns:group>"
        +"<tns:lat>-36.869</tns:lat>"
        +"<tns:lon>174.746</tns:lon>"
        +"<tns:name>SH16 1 Bond St</tns:name>"
        +"<tns:viewUrl>http://www.trafficnz.info/camera/view/130</tns:viewUrl>"
        +"  </tns:camera>";


         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
             new XmlParsing(data).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null});
         else
             new XmlParsing(data).execute(new String[]{null});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public class XmlParsing extends AsyncTask<String, Void, String> {

        // variables passed in:
        String data;
        //  constructor
        public XmlParsing(String data) {
            this.data = data;
        }

        @Override
        protected void onPreExecute() {
            pDialog = ProgressDialog.show(FileActivity.this, "Fetching Details..", "Please wait...", true);
        }


        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub

            try {               

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();

                FileOutputStream out = openFileOutput("hello.txt",Context.MODE_PRIVATE);

                out.write(data.getBytes());
                out.close();                

                BufferedReader input = new BufferedReader(new InputStreamReader(openFileInput("hello.txt")));               
                StringBuffer inLine = new StringBuffer();

                String text;
                while ((text = input.readLine()) != null) {
                    inLine.append(text);
                    inLine.append("\n");
                }
                input.close();

                String finalData =inLine.toString();  

                InputStream is = new ByteArrayInputStream(finalData.getBytes("UTF-8"));

                Document doc = dBuilder.parse(is);

                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getElementsByTagName("tns:camera");

                for (int i = 0; i < nodeList.getLength(); i++) {

                    Node node = nodeList.item(i);       

                    Element fstElmnt = (Element) node;
                    NodeList nameList = fstElmnt.getElementsByTagName("tns:group");
                    Element nameElement = (Element) nameList.item(0);
                    nameList = nameElement.getChildNodes();

                    Log.v("tns:group : "+((Node) nameList.item(0)).getNodeValue());


                    Element fstElmnt1 = (Element) node;
                    NodeList nameList1 = fstElmnt1.getElementsByTagName("tns:viewUrl");
                    Element nameElement1 = (Element) nameList1.item(0);
                    nameList1 = nameElement1.getChildNodes();

                    Log.v("tns:viewUrl : "+ ((Node) nameList1.item(0)).getNodeValue());


                    if(node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element e = (Element) node;
                        NodeList resultNodeList = e.getElementsByTagName("tns:congestionLocations");
                        int resultNodeListSize = resultNodeList.getLength();
                        for(int j = 0 ; j < resultNodeListSize ; j++ )
                        {
                            Node resultNode = resultNodeList.item(j);
                            if(resultNode.getNodeType() == Node.ELEMENT_NODE)
                            {
                                Element fstElmnt2 = (Element) resultNode;
                                NodeList nameList2 = fstElmnt2.getElementsByTagName("tns:congestion");
                                Element nameElement2 = (Element) nameList2.item(0);
                                nameList2 = nameElement2.getChildNodes();

                                Log.v("tns:congestion", ""+((Node) nameList2.item(0)).getNodeValue());

                                Element fstElmnt3 = (Element) resultNode;
                                NodeList nameList3 = fstElmnt3.getElementsByTagName("tns:direction");
                                Element nameElement3 = (Element) nameList3.item(0);
                                nameList3 = nameElement3.getChildNodes();

                                Log.v("tns:direction--", ""+((Node) nameList3.item(0)).getNodeValue());
                            }
                        }
                    }

                }




            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            // Now we have your JSONObject, play around with it.
            if (pDialog.isShowing())
                pDialog.dismiss();


        }

    }
}