Assert.assertEquals(21, 25); //here the code execution stops

//here the code fails yet the script will continue its execution.
try{
 Assert.assertEquals(21, 25);
 }catch(Exception e){
e.printStackTrace();
}