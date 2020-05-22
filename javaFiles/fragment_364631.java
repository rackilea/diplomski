public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap();
          try {
              BufferedReader reader = new BufferedReader(new FileReader(new File("C:/iPhone/persons.txt")));
              String line = "";
              String [] person;
              while ((line = reader.readLine()) != null) {
                  person = line.split(" ");
                  String name = person[0];
                  int number = Integer.parseInt(person[person.length-1]);
                  map.put(name,map.getOrDefault(name,0)+number);
              }
              reader.close();
          } catch (IOException ioe) {
              ioe.printStackTrace();
          }
          map.forEach((k,v)->System.out.println(k + " = " + v));
        }