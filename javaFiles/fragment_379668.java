import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineOperation {

private static List<String> lines;

public static void main(String[] args) throws IOException {

    lines = Collections.emptyList();

    try {
          lines = Files.readAllLines(Paths.get("C:\\Users\\Abhinav\\Downloads\\TempData2018a.txt"), StandardCharsets.UTF_8);

          String stationName = lines.get(0);

          String[] arr = null;

          ArrayList<StationRecord> data = new ArrayList<>();

          for(int i=1;i<lines.size();i++) {

              arr = lines.get(i).split(" ");

              data.add(new StationRecord(Long.parseLong(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Double.parseDouble(arr[4])));
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
}
}