import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class MapMergeTest
{
    public static void main(String[] args)
    {
        List<Map<String, Object>> maps = createInput();

        System.out.println("Input:");
        for (Map<String, Object> map : maps)
        {
            System.out.println(map);
        }

        List<Map<String, Object>> result = createMergedMapsList(maps);

        System.out.println("Result:");
        for (Map<String, Object> map : result)
        {
            System.out.println(map);
        }
    }


    private static List<Map<String, Object>> createInput()
    {
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        //                senseId  clusterList...
        maps.add(createMap(65786,  71051));
        maps.add(createMap(65787,  71051));
        maps.add(createMap(65788,  4985, 71052));
        maps.add(createMap(71051,  125840, 153610, 167812, 
            65787, 204091, 32586, 65786));
        maps.add(createMap(71052,  11470, 65788));
        return maps;
    }
    private static Map<String, Object> createMap(
        Integer senseId, Integer ... clusters)
    {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("senseId", senseId);
        result.put("clusterList", new ArrayList<Integer>(Arrays.asList(clusters)));
        return result;
    }



    private static List<Map<String, Object>> createMergedMapsList(
        List<Map<String, Object>> maps)
    {
        Map<Integer, Map<String, Object>> senseIdToMap =
            createSenseIdToMap(maps);

        Map<Integer, Map<String, Object>> copy = 
            new LinkedHashMap<Integer, Map<String,Object>>(senseIdToMap);
        for (Entry<Integer, Map<String, Object>> e : copy.entrySet())
        {
            Integer senseId = e.getKey();
            Map<String, Object> map = e.getValue();
            List<Integer> clusterList = getClusterList(map);
            List<Map<String, Object>> mapsToMerge = 
                new ArrayList<Map<String,Object>>();
            mapsToMerge.add(map);
            for (Integer cluster : clusterList)
            {
                Map<String, Object> mapToMerge =
                    senseIdToMap.get(cluster);
                if (mapToMerge != null)
                {
                    mapsToMerge.add(mapToMerge);
                    senseIdToMap.remove(cluster);
                }
            }
            if (mapsToMerge.size() > 1)
            {
                Map<String, Object> mergedMap = mergeMaps(mapsToMerge);
                List<Integer> mergedClusterList = getClusterList(mergedMap);
                mergedClusterList.remove(senseId);
                senseIdToMap.put(senseId, mergedMap);
            }
        }
        return new ArrayList<Map<String,Object>>(senseIdToMap.values());
    }

    private static Map<Integer, Map<String, Object>> createSenseIdToMap(
        List<Map<String, Object>> maps)
    {
        Map<Integer, Map<String, Object>> senseIdToMap = 
            new LinkedHashMap<Integer, Map<String,Object>>();
        for (Map<String, Object> map : maps)
        {
            Integer senseId = (Integer)map.get("senseId");
            senseIdToMap.put(senseId, map);
        }
        return senseIdToMap;
    }

    private static Map<String, Object> mergeMaps(List<Map<String, Object>> list)
    {
        Map<String, Object> mergedMap = new LinkedHashMap<String, Object>();
        Map<String, Object> firstMap = list.get(0);
        mergedMap.put("senseId", firstMap.get("senseId"));
        Set<Integer> mergedClusterList = new LinkedHashSet<Integer>();
        for (Map<String, Object> map : list)
        {
            List<Integer> clusterList = getClusterList(map);
            mergedClusterList.addAll(clusterList);
        }
        mergedMap.put("clusterList", new ArrayList<Integer>(mergedClusterList));
        return mergedMap;
    }


    private static List<Integer> getClusterList(Map<String, Object> map)
    {
        Object object = map.get("clusterList");
        return (List<Integer>)object;
    }

}