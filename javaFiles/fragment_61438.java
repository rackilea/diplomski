public class Csv{

   private BufferedReader fin;
   private String fieldsep;
   private ArrayList<String> field;

   public Csv(){
      this(System.in, ",");
   }


   public Csv(InputStream in, String sep){
      this.fin = new BufferedReader(new InputStreamReader(in));
      this.fieldsep = sep;
   }

   // getline: get one line, grow as needed
   public String getline() throws IOException {
      String line;
      line = fin.readLine();
      if (line == null)
        return null;
      field = split(line, fieldsep);
      return line;
   }

   // split: split line into fields
   private ArrayList split(String line, String sep){
      List<String> list = new ArrayList();
      StringTokenizer tokens = new StringTokenizer(line, sep, false);
      while (tokens.hasMoreElements()) {
            String next = (String) tokens.nextElement();
            next = next.trim().replaceAll("\"\"", "\"");
            list.add(next);
      }
      return list;
   }
}