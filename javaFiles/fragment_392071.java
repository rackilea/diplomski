List<String> list = new ArrayList();
  String pathname = "F:\\Calibration.txt";
  try (FileReader reader = new FileReader(pathname);
    BufferedReader br = new BufferedReader(reader)) 
{
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
       }

 }