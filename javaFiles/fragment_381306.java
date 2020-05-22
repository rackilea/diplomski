public static String readFromFile(String filePath){
    String total="";
    File file=new File(filePath);
      try {
        String encoding="GBK";
              if(file.isFile() && file.exists()){ //判断文件是否存在
               InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到汉子编码格式
               BufferedReader bufferedReader = new BufferedReader(read);
               String lineTxt = null;
               while((lineTxt = bufferedReader.readLine()) != null){
                   total+=lineTxt;
               }
               read.close();
      }else if(!file.exists())
      {
        file.createNewFile();
      }
      } catch (Exception e) {
       System.out.println("读取文件内容出错");
       e.printStackTrace();
      }
     return total;
     }