package test;

import java.sql.*;
import java.util.*;
import java.util.concurrent.*;

import net.sf.json.*;

public class StackOverflowQ10976771_ResultSetToJSON
{
    public static void appendValue (Map<String,  List<Integer>> map, String key, int value)
    {
        List<Integer> values = map.get (key);
        if (values == null)
        {
            values = new ArrayList<Integer> ();
            map.put (key, values);
        }
        values.add (value);
    }

    public static void main (String[] args)
    {
        Map<String, List<Integer>> code1_code2 = new ConcurrentSkipListMap<String, List<Integer>> ();
        Map<String, List<Integer>> code2_code3 = new ConcurrentSkipListMap<String, List<Integer>> ();
        Map<String, List<Integer>> code3_code4 = new ConcurrentSkipListMap<String, List<Integer>> ();

        int[][] sample_resultSet = {
                {1, 11, 111, 1111},
                {2, 21, 211, 2111},
                {2, 22, 221, 2211},
                {2, 21, 212, 2121},
        };

        //ResultSet rs = null;
        //while (rs.next ())
        for (int[] rs : sample_resultSet)
        {
            appendValue (code1_code2, String.valueOf(rs[0]), rs[1]);
            appendValue (code2_code3, String.valueOf(rs[1]), rs[2]);
            appendValue (code3_code4, String.valueOf(rs[2]), rs[3]);
        }

        System.out.println ("code1_code2 =");
        System.out.println (JSONObject.fromObject (code1_code2).toString(4 ,4) + ";");
        System.out.println ();

        System.out.println ("code2_code3 = ");
        System.out.println (JSONObject.fromObject (code2_code3).toString(4 ,4) + ";");
        System.out.println ();

        //System.out.println ("code3_code4 = ");
        //System.out.println (JSONObject.fromObject (code3_code4).toString(4 ,4) + ";");
        //System.out.println ();
    }
}