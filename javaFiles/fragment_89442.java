try{ 
     Scanner scan = new Scanner(new File(folder + "file.txt"));
     data=scan.nextLine();
     scan.close();
     }catch(FileNotFoundException ex){
          System.out.println("Caught " + ex );
     }finally{
          System.out.println("Finally ");
     }