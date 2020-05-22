import java.util.Arrays;

public class Main16 {
    public static void main(String[] args) {
        String sample1 = "productName/@languageCode";
        String sample2 ="brandNameInformation/languageSpecificBrandName/@languageCode";

        String regex = "/(?!@)";

        System.out.println(Arrays.deepToString(sample1.split(regex)));
        System.out.println(Arrays.deepToString(sample2.split(regex)));
    }
}