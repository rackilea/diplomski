dataObject = table.getValueAt(row, column);
if(dataObject == null || "".equals(dataObject)) {
     System.out.println("No value");
} else {
      dataString = dataObject.toString();
      if(dataString ==null || "".equals(dataString) )
          System.out.println("No value");
       else
         System.out.print(dataString+", ");
}