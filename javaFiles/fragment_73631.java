public class EmployeeReader {

    public static void main(String[] args) throws IOException {
        File file = new File("employees.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        while ((line = br.readLine()) != null) {
            if (!line.trim().equals("")) {
                String[] tokens = line.split(":");
                if (tokens[0].trim().equals("Name") || tokens[0].trim().equals("Salary")) {
                    map.put(tokens[0].trim(),tokens[1].trim());                 
                }
            } else {
                list.add(map);
                map = new HashMap<String, String>();
            }
        }
        list.add(map);

        printList(list);
        br.close();
    }

    public static void printList(List<Map<String, String>> list) {
        for (Map<String, String> employee : list) {
            System.out.println("EMPLOYEE");
            for (Entry<String, String> entry : employee.entrySet()) {
                System.out.println("Key: " + entry.getKey());
                System.out.println("Value: " + entry.getValue());
            }
        }   
    }
}