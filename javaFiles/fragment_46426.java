double[] firstColumn = new double[30000];
double[] secondColumn = new double[30000];
int index = 0;

try {
      BufferedReader in = new BufferedReader(new FileReader("input.dat"));
      String str = in.readLine();

      while ((str = in.readLine()) != null) {
             String[] values = str.split(",");
             firstColumn[index] = Double.parseDouble(values[0]);
             secondColumn[index++] = Double.parseDouble(values[1]);         
      }

       in.close();
    } 
catch (IOException e) 
{
  // do the logging.
}