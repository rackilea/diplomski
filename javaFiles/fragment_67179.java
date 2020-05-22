package CustomDataAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchAdapter implements JRDataSource {

    /**
     * This will hold the JSON returned by generic search service
     */
    private JSONObject json = null;

    /**
     * Ensures that we infinitely calling the service.
     */
    private boolean flag = false;
    /**
     * Will create the object with data retrieved from service.
     */
    private void setJson() {
        String url = "[URL is here]";
        String request = "{\"searchType\": \"Test\", \"searchTxt\": \"Test\"}";

        // Setting up post client and request.
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        HttpResponse response = null;

        post.setHeader("userId", "1000");
        post.setHeader("Content-Type", "application/json");

        // Setting up Request payload
        StringEntity entity = null;
        try {
            entity = new StringEntity(request);
            post.setEntity(entity);

            // do post
            response = client.execute(post);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Reading Server Response
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                // Thrown Exception in case things go wrong
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String inputLine;
                StringBuffer resp = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    resp.append(inputLine);
                }

                in.close();

                String ex = "Search Failed. Status Code: " + statusCode;
                ex += "\n Error: " + resp.toString();
                throw new Exception(ex);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
            String inputLine;
            StringBuffer resp = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                resp.append(inputLine);
            }

            in.close();

            this.json = new JSONObject(resp.toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.sf.jasperreports.engine.JRDataSource#getFieldValue(net.sf.jasperreports
     * .engine.JRField)
     */
    @Override
    public Object getFieldValue(JRField field) throws JRException {
        // TODO Auto-generated method
        // stubhttp://community-static.jaspersoft.com/sites/default/files/images/0.png
        try {
            return this.json.get(field.getName());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.jasperreports.engine.JRDataSource#next()
     */
    @Override
    public boolean next() throws JRException {
        if (this.json != null && !flag) {
            flag = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return an instance of the class that implements the custom data adapter.
     */
    public static JRDataSource getDataSource() {
        SearchAdapter adapter = new SearchAdapter();
        adapter.setJson();
        return adapter;
    }

}