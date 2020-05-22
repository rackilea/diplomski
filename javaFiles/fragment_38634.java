import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class SearchJson {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://api.openeventdatabase.org/event/b2e7df60-3f25-4d80-b7ac-cffc10dd5313");
        URLConnection connection = url.openConnection();
        String jsonString = toString(new InputStreamReader(connection.getInputStream()));

        Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonString);

        Integer nbDesCarburants = (Integer) JsonPath.read(document, "$.properties.carburants.length()");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Carburant> carburants = new ArrayList<>();
        for (int i = 0; i < nbDesCarburants; i++) {
            Map<String, Object> carburantMap = (Map<String, Object>) JsonPath.read(document,
                    "$.properties.carburants[" + i + "]");
            String nom = (String) carburantMap.get("carburant");
            Date maj = simpleDateFormat.parse(carburantMap.get("maj").toString());
            float prix = Float.parseFloat(carburantMap.get("prix").toString());
            Carburant carburant = new Carburant(nom, maj, prix);
            carburants.add(carburant);
        }


        for (Carburant carburant : carburants) {
            System.out.println(carburant);
        }

    }

    static class Carburant {
        private final String nom;
        private final Date date;
        private final float prix;
        public Carburant(String nom, Date date, float prix) {
            super();
            this.nom = nom;
            this.date = date;
            this.prix = prix;
        }
        @Override
        public String toString() {
            return "Carburant [nom=" + nom + ", date=" + date + ", prix=" + prix + "]";
        }

    }

    public static String toString(InputStreamReader reader) throws IOException {
        char[] charBuf = new char[1024];
        int read = reader.read(charBuf, 0, 1024);
        StringBuilder sb = new StringBuilder();
        while (read != -1) {
            sb.append(new String(charBuf));
            charBuf = new char[1024];
            read = reader.read(charBuf, 0, 1024);
        }
        sb.append(new String(charBuf));
        return sb.toString();
    }

}