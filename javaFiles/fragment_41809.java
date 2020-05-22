public void writeFile(String sorcefile) 
{
     try{
          FileInputStream fis = new FileInputStream(sorcefile);
          DataInputStream dis = new DataInputStream(fis);
          BufferedReader br = new BufferedReader(new InputStreamReader(dis));
          FileWriter fw=new FileWriter("src/output.java",true);
          BufferedWriter bw=new BufferedWriter(fw);
          String strLine;
          //Read File Line By Line
          while ((strLine = br.readLine()) != null)   
          {
          System.out.println (strLine);
          bw.append(strLine);
          }           
          //Close the input stream
          br.close();
          dis.close();
          fis.close();
          fw.flush();
          bw.flush();
          fw.close();
          bw.close();             
            }catch (Exception e){//Catch exception if any
          System.err.println("Error: " + e.getMessage());
          }
}