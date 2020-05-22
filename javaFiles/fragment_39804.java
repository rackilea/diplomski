import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) {
        String [] [] array = {
                {"804", "2007-01-02", "1", "Alkalinity", "38.6"},
                {"804", "2007-01-02", "1", "Alkalinity", "39.6"},
                {"804", "2007-01-02", "1",  "PH", "36.6"},
                {"804", "2007-01-02", "1", "Conductivity", "40.8"},
                {"804", "2008-10-02", "10",  "Alkalinity", "39.5"},
                {"817", "04-10-99", "10",  "Alkalinity",  "38.4"},
                {"826", "04-10-99", "10", "PH",  "38.2"}
            } ;

        List<String[]> list = new ArrayList<String[]>();
        for (int i = 0; i < array.length; i++)
            list.add(array[i]);
        Collections.sort(list, arrComparator);

        System.out.println("Sorted list:");
        for (String[] s : list)
            System.out.println(Arrays.toString(s));

        List<String[]> newList = new ArrayList<String[]>();
        String[] strArr = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            double sum = 0.0;
            int count = 1;
            while (strArr[1].equals(list.get(i)[1]) && strArr[3].equals(list.get(i)[3])) {
                sum += Double.parseDouble(strArr[4]) + Double.parseDouble(list.get(i)[4]);
                strArr = list.get(i);
                i++;
                count++;
            }
            if (count > 1) {
                newList.add(new String[] { strArr[0], strArr[1], strArr[2], strArr[3], String.valueOf(sum / count) });
            } else {
                newList.add(strArr);
            }
            strArr = list.get(i);
        }
        newList.add(list.get(list.size() - 1));

        System.out.println("Final list:");
        for (String[] s : newList)
            System.out.println(Arrays.toString(s));
    }

    public static Comparator<String[]> arrComparator = new Comparator<String[]>() {
        @Override
        public int compare(String[] strArr1, String[] strArr2) {
            String date1 = strArr1[1];
            String date2 = strArr2[1];
            int sComp = date1.compareTo(date2);
            if (sComp != 0) {
                return sComp;
            }
            return strArr1[3].compareTo(strArr2[3]);
        }
    };
}