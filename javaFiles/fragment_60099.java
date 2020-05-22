import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestSample {
    @Test(dataProvider = "dp")
    public void testMethod(JsonElement record) {
        System.err.println("Data : " + record.getAsJsonObject().toString());
    }

    @DataProvider(name = "dp")
    public Object[][] getData() throws FileNotFoundException {
        JsonArray array = new JsonParser().parse(new FileReader("src/test/resources/49466822.json")).getAsJsonArray();
        Object[][] data = new Object[array.size()][1];
        for (int i = 0; i < array.size(); i++) {
            data[i][0] = array.get(i);
        }
        return data;
    }
}