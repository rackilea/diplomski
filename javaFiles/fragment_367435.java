while(true) {
  try{
    Ship copyObject = (Ship)inputStream.readObject();
    System.out.println(copyObject.getShipName() + "       " + copyObject.getRevenue());
  }
  catch(Exception ex) {
    System.out.println("No more ships");
    break;
  }
}