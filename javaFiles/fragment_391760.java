private String getContents(Cell cell) {
    DateCell dCell=null;
    if(cell.getType() == CellType.DATE)
    {
      dCell = (DateCell)cell;
      // System.out.println("Value of Date Cell is: " + dCell.getDate()); 
      // ==> Value of Date Cell is: Thu Apr 22 02:00:00 CEST 2088
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
      // System.out.println(sdf.format(dCell.getDate()));
      // ==> 2088-04-22   
      return sdf.format(dCell.getDate());
    }
    // possibly manage other types of cell in here if needed for your goals   
    // read more: http://www.quicklyjava.com/reading-excel-file-in-java-datatypes/#ixzz2fYIkHdZP 
    return cell.getContents();
}