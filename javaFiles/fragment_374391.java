import java.util.Arrays;

import com.google.gson.Gson;

public class Test {
    public static void main(String[] args) {
        ColsDataset cols1 = new ColsDataset();
        cols1.setId("");
        cols1.setLabel("Impressions");
        cols1.setPattern("");
        cols1.setType("number");

        ColsDataset cols2 = new ColsDataset();
        cols2.setId("");
        cols2.setLabel("Spend");
        cols2.setPattern("");
        cols2.setType("number");

        RowsDataset rows = new RowsDataset();

        //TODO Add row data.

        Bing bing = new Bing();
        bing.setColsDataset(Arrays.asList(cols1, cols2));

        Gson gson = new Gson();

        System.out.println(gson.toJson(bing));
    }
}