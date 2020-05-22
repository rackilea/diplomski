public class Zoo {

    public static void main(String[] args) {
        List<String> zoo = new ArrayList<String>();
        zoo.add("Zebra");
        zoo.add("Deer");
        zoo.add("Giraffe");
        zoo.add("Deer");
        while(!zoo.isEmpty()) {
            String bigger = "";
            for(String animal : zoo) {
                if(animal.length() > bigger.length()) {
                    bigger = animal;
                }
            }
            System.out.println(bigger);
            while(zoo.contains(bigger)) {
                zoo.remove(bigger);
            }
        }
    }

}