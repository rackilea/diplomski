public Food (String[] data){
  if (data==null || data.length!=4){
     // error handling
  }
  this.name=data[0];
  ...
  this.availability="Yes".equals(data[3])
}