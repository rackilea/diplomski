/**
  Writes a pet record to the file
  @param pet The pet record to write
  */
  public static void writePet(PetRecord pet){
    if (fileName.exists()){
      AppendObjectOutputStream handle = null;
      try{
        handle = new AppendObjectOutputStream(new FileOutputStream(fileName, true));
        handle.writeObject(pet);
        handle.flush();
      } catch (IOException e){
        System.out.println("Fatal Error!");
        System.exit(0);
      } finally {
        try{
          handle.close();
        } catch (IOException e){
          e.printStackTrace();
        }
      }
    } else {
      ObjectOutputStream handle = null;
      try{
        handle = new ObjectOutputStream(new FileOutputStream(fileName));
        handle.writeObject(pet);
        handle.flush();
      } catch (IOException e){
        System.out.println("Fatal Error!");
        System.exit(0);
      } finally {
        try{
          handle.close();
        } catch (IOException e){
          e.printStackTrace();
        }
      }
    }
  }