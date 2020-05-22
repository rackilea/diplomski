import java.util.*;

class LegacyGlueifier
{
    private LegacyGlueifier()
    {
    }

    public static String generateLegacyDataset(Map<String, String> data)
    {
        final ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        final int width = data.size();

        int i = 0;
        for (Map.Entry<String, String> entry : data.entrySet())
        {
            String[] values = entry.getValue().split(",");
            changeDims(lists, width, values.length + 1);

            for (int j = 0; j < values.length; ++j) setValue(lists, j + 1, i, values[j]);
            setValue(lists, 0, i, entry.getKey());
            ++i;
        }

        return stringify(lists);
    }

    private static void changeDims(ArrayList<ArrayList<String>> lists, int width, int newHeight)
    {
        while (lists.size() < newHeight) lists.add(arrayListOfSize(width));
    }

    private static ArrayList<String> arrayListOfSize(int w)
    {
        ArrayList<String> list = new ArrayList<String>(w);
        while (list.size() < w) list.add(null);
        return list;
    }

    private static void setValue(ArrayList<ArrayList<String>> lists, int row, int col, String val)
    {
        ArrayList<String> temp = lists.get(row);
        temp.set(col, val);
        // System.out.println("SET: " + row + " " + col + ": " + val);
    }

    private static String swapNullWithEmpty(String s)
    {
        if (s == null) return "";
        return s;
    }

    private static String stringify(ArrayList<ArrayList<String>> lists)
    {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<String> sublist : lists)
        {
            if (sublist.size() != 0) sb.append(swapNullWithEmpty(sublist.get(0)));
            for (int i = 1; i < sublist.size(); ++i)
                sb.append("|").append(swapNullWithEmpty(sublist.get(i)));
            sb.append("\n");
        }

        return sb.toString();
    }
}