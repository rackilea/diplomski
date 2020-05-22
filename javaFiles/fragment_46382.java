static List<List<Integer>> list1 = new ArrayList<>();
public static void main(String[] args) {
    List<Integer> lt1 = new ArrayList<>(Arrays.asList(1,2,3));
    list1.add(lt1);
    List<Integer> lt2 = new ArrayList<>(Arrays.asList(4,5,6));
    list1.add(lt2);
    List<Integer> lt3 = list1.get(0); // Same as lt1
    System.out.println(lt3.get(0)); // Outputs 1
}