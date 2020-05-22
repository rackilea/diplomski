public static void main(String[] args)throws Exception 
      { 
      File file = new File("/root/test.txt"); 

      BufferedReader br = new BufferedReader(new FileReader(file)); 

      String st; 
      while ((st = br.readLine()) != null) {

          if(st.lastIndexOf("Name:") >= 0 || st.lastIndexOf("Age:") >= 0) {
              System.out.println(st.substring(st.lastIndexOf(":")+1));
          }
      }
      }