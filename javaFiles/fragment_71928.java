import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cjm.component.cb.map.ToMap;

public class DummyClass
{
public static void main(String[] args)
{
    try
    {
        String xml = "<?xml version=\"1.0\"?><Gist xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"../schema/Gist.xsd\"><Name>AboveOrEqualToThreshold</Name><Version>1</Version><Tags><Tag>Comparison</Tag></Tags><Description>Determines if a value is at or over a threshold or not.</Description><Configuration /><OutputType><ScalarType>Boolean</ScalarType></OutputType><PertinentData><Item><Name>ValueMinusThreshold</Name></Item><Item><Name>ThresholdMinusValue</Name></Item></PertinentData><Scenarios><Scenario><ID>THRESHOLD_DOES_NOT_APPLY</ID><Description>The threshold does not apply.</Description></Scenario><Scenario><ID>ABOVE_THRESHOLD</ID><Description>The value is above the threshold.</Description></Scenario><Scenario><ID>EQUAL_TO_THRESHOLD</ID><Description>The value is equal to the threshold.</Description></Scenario><Scenario><ID>NOT_ABOVE_THRESHOLD</ID><Description>The value is not above the threshold.</Description></Scenario></Scenarios></Gist>";

        Map<String, Object> map = (new ToMap()).convertToMap(xml); // Conversion Box

        Map<String, Object> mapGist = (Map<String, Object>) map.get("Gist");

        String name = (String) mapGist.get("Name");

        List<Map<String, Object>> scenarioMapList = (List<Map<String, Object>>) mapGist.get("Scenarios");

        List<String> scenarioList = new ArrayList<String>();

        for (int index = 0; index < scenarioMapList.size(); index++)
        {
            Map<String, Object> scenarioMap = scenarioMapList.get(index);

            scenarioList.add((String) scenarioMap.get("ID"));
        }

        Map<String, List<String>> whatMosawiWants = new HashMap<String, List<String>>();

        whatMosawiWants.put(name, scenarioList);

        System.out.println("What Mosawi wants: " + whatMosawiWants);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}
}