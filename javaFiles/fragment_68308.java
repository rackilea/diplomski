import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTabDelim {

    public static void main(String[] args) {
        Params params = new Params();
        params.setDataType("abc");
        List<String> scene = new ArrayList<>();
        scene.add("AC");
        params.setScene(scene);
        List<String> company = new ArrayList<>();
        company.add("pr");
        params.setCompany(company);
        List<Map<String, List<String>>> fit = new ArrayList<>();
        List<String> fitInner = new ArrayList<>();
        fitInner.add("A1");
        Map<String, List<String>> fitMap = new HashMap<>();
        fitMap.put("prod", fitInner);
        fit.add(fitMap);
        params.setFit(fit);
        params.setTempo("note");
        params.setId("123");
        params.setValuation("USD");

//      Uncomment the following lines to see how Aggregate works:
//      List<Aggregate> aggregates = new ArrayList<>();
//      Aggregate ag = new Aggregate();
//      ag.setData("some_data");
//      aggregates.add(ag);
//      params.setAggregates(aggregates);

        System.out.println(params.toTabbedString());
    }
}