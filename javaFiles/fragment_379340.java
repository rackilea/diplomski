public class App {

    static String answer(int index) {
        return index < 0 ? "No" : "Yes";
    }

    public static void main(String[] args) {
        String line = "1,4,test,v,4t,10,20,more";

        String[] arr = line.split(",");

        Arrays.sort(arr);

        System.out.println(String.format("Does the source string have 1 in it? %s", answer(Arrays.binarySearch(arr, "1"))));
        System.out.println(String.format("Does the source string have 10 in it? %s", answer(Arrays.binarySearch(arr, "10"))));
        System.out.println(String.format("Does the source string have v in it? %s", answer(Arrays.binarySearch(arr, "v"))));
        System.out.println(String.format("Does the source string have 01 in it? %s", answer(Arrays.binarySearch(arr, "01"))));
        System.out.println(String.format("Does the source string have va in it? %s", answer(Arrays.binarySearch(arr, "va"))));
        System.out.println(String.format("Does the source string have test,v in it? %s", answer(Arrays.binarySearch(arr, "test,v"))));

    }
}