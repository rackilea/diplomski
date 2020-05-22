import java.util.*;

public class Test
{
    public static void main(String[] args) {
        List<String> prefix = Arrays.asList("java.", "javax.", "org.");
        List<String> imports = Arrays.asList("org.testng.annotations.Test", "java.util.Arrays", "javax.annotation.Generated", "org.testng.annotations.Optional", "de.bigmichi1.test.ClassB");
        Collections.sort(imports, new Comparator<String>(){
            int prefix1Index = Integer.MAX_VALUE, prefix2Index = Integer.MAX_VALUE;
            @Override
            public int compare(String o1, String o2) {
                prefix1Index = Integer.MAX_VALUE;
                prefix2Index = Integer.MAX_VALUE;
                prefix.forEach((pre) -> {
                    if(o1.startsWith(pre)){
                        prefix1Index = prefix.indexOf(pre);
                    }
                    if(o2.startsWith(pre)){
                        prefix2Index = prefix.indexOf(pre);
                    }
                });

                if(prefix1Index == prefix2Index) return o1.compareTo(o2);
                else return prefix1Index - prefix2Index;
            }
        });

        imports.forEach((imported) -> {
            System.out.println(imported);
        });

    }
}