public class App 
{
    public static void main( String[] args )
    {
        HashMap<String, Person> persons = new HashMap<String, Person>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Public Administrator\\test.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line = null;

        try {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String personName = fields[0];
                Person existingPerson = persons.get(personName);
                if (existingPerson==null){
                    Person newPerson = new Person();
                    newPerson.setName(personName);
                    newPerson.getCompanyExperience().put(Integer.parseInt(fields[2])+fields[1], fields[1]);
                    persons.put(personName, newPerson);
                } else{
                    existingPerson.getCompanyExperience().put(Integer.parseInt(fields[2])+fields[1], fields[1]);
                }
             }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    

        //output
        Iterator<Map.Entry<String, Person>> entries = persons.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Person> entry = entries.next();
            Person _person = entry.getValue();
            System.out.print(_person.getName());

            Iterator<Map.Entry<String, String>> companyExperiences = _person.getCompanyExperience().entrySet().iterator();
            while (companyExperiences.hasNext()) {
                Map.Entry<String, String> companyExperience = companyExperiences.next();

                System.out.print(" > "+companyExperience.getValue());
            }
            System.out.println();

        }
    }
}