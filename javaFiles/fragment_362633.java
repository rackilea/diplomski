@Model
public class StockUploadController {
 ...
    public void parse(String filename){

        Map<String, List<String>> subSectorToStockMap = new HashMap<>();
        SubSectorToStockParser parser = new SubSectorToStockParser(subSectorToStockMap);  //SubSectorToStockParser should be injected
        parser.parse(filename);

    }
...