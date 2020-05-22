File f = new File("C:\\TEST");
try{
    if(f.mkdir()) { 
        System.out.println("Directory Created");
    } else {
        System.out.println("Directory is not created");
    }
} catch(Exception e){
    e.printStackTrace();
}