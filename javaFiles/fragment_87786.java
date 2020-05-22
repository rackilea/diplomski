public class Sorter {

    public static void main(String[] args) {
        NameDescription namesDescriptions[] = {
                new NameDescription("Drinks", "this is drinks package"),
                new NameDescription("Bikes", "package for bikes"),
                new NameDescription("Cars", "package cars"),
            };

        Arrays.sort(namesDescriptions);

        // ASCENDING
        for(int i=0; i<namesDescriptions.length; i++) {
            System.out.println(namesDescriptions[i].getName());
        }
        for(int i=0; i<namesDescriptions.length; i++) {
            System.out.println(namesDescriptions[i].getDescription());
        }

        System.out.println("---------");

        // DESCENDING
        for(int i=namesDescriptions.length-1; i>=0; i--) {
            System.out.println(namesDescriptions[i].getName());
        }
        for(int i=namesDescriptions.length-1; i>=0; i--) {
            System.out.println(namesDescriptions[i].getDescription());
        }

        // To save them in separate arrays
        String[] names = new String[namesDescriptions.length];
        String[] desc = new String[namesDescriptions.length];
        String[] imageid = new String[namesDescriptions.length];
        for(int i=0; i<namesDescriptions.length; i++) { 
            names[i] = namesDescriptions[namesDescriptions.length-i-1].getName();
            desc[i] = namesDescriptions[namesDescriptions.length-i-1].getDescription();
            imageid[i] = namesDescriptions[namesDescriptions.length-i-1].getimg();
        }
    }

}