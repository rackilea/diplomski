//get all the files from a directory
File[] fList = directory.listFiles();
for (File file : fList){
    if (file.isFile()){
        System.out.println(file.getName());
    }// end if 
}// end for 

System.out.println("Enter 1-"+ RecipeCount + "to select a recipe card" );