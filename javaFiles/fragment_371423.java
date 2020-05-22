public class Extract {



    public HashMap<String, HashMap<String, String>> readFile(String filename)   {

        HashMap<String, HashMap<String, String>> people = new HashMap<>();
        HashMap<String, String> metaData = new HashMap<>();

        try {
            Scanner in = new Scanner(new File(filename));
            String line;

            while(in.hasNext()) {
                line = in.nextLine();
                String[] keyValue = line.split(",");

                // 1st put email address and age in the inner Map
                metaData = new HashMap<>();
                metaData.put("email", keyValue[1]);
                metaData.put("age", keyValue[2]);

                // 2nd put the inner Map into the outer Map, referenced by the person's name
                people.put(keyValue[0], metaData);
            }
            in.close();
        }

        catch(Exception e)    {
            e.printStackTrace();
        }

        return people;
    }
}


public class Main {

    public static void main(String[] args) {

        Extract e = new Extract();

        String peopleFile = ("relationships.csv");
        HashMap<String, HashMap<String, String>> person1 = e.readFile(peopleFile);

        // 1st:  get the inner Map of Bob
        // If you use the get()-method, you tell the outer Map to hand you the inner Map of Bob.
        HashMap<String, String> metaData = person1.get("Bob");

        // 2nd: get the metaData off the inner Map
        String email = metaData.get("email");
        Integer age = Integer.valueOf(metaData.get("age"));
    }
}