import com.example.ElemntList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    private static Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "{\"mentions\":[{\"allEntities\":[{\"kbIdentifier\":\"YAGO:Bob_Dylan\",\"disambiguationScore\":\"0.63692\"}],\"name\":\"Dylan\",\"bestEntity\":{\"kbIdentifier\":\"YAGO:Bob_Dylan\",\"disambiguationScore\":\"0.63692\"}},{\"name\":\"Duluth\",\"bestEntity\":{\"kbIdentifier\":\"YAGO:Duluth\\u002c_Minnesota\",\"disambiguationScore\":\"0.63149\"}}]}";
        ElemntList info = gson.fromJson(s, ElemntList.class);
        System.out.println(info);
   }
}