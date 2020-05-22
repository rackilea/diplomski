import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Vector;

public class Foo {

    private LinkedHashMap<String, Vector<String>> dataStructure;

    public Foo(LinkedHashMap<String, Vector<String>> dataStructure){
        this.dataStructure = dataStructure;
    }

    public String[][] allUniqueCombinations(){
        int n = dataStructure.keySet().size();
        int solutions = 1;

        for(Vector<String> vector : dataStructure.values()) {
            solutions *= vector.size();            
        }

        String[][] allCombinations = new String[solutions + 1][];
        allCombinations[0] = dataStructure.keySet().toArray(new String[n]);

        for(int i = 0; i < solutions; i++) {
            Vector<String> combination = new Vector<String>(n);
            int j = 1;
            for(Vector<String> vec : dataStructure.values()) {
                combination.add(vec.get((i/j)%vec.size()));
                j *= vec.size();
            }
            allCombinations[i + 1] = combination.toArray(new String[n]);
        }

        return allCombinations;
    }

    public static void main(String[] args) {
        LinkedHashMap<String, Vector<String>> data = new LinkedHashMap<String, Vector<String>>();
        data.put("foo", new Vector<String>(Arrays.asList("1", "2", "3")));
        data.put("bar", new Vector<String>(Arrays.asList("3", "2")));
        data.put("baz", new Vector<String>(Arrays.asList("5", "6", "7")));

        Foo foo = new Foo(data);

        for(String[] combination : foo.allUniqueCombinations()) {
            System.out.println(Arrays.toString(combination));            
        }
    }
}