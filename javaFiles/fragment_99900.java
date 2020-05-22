boolean isfound = false;
for(int i = 0; i < list.size(); i++){
    if(list.get(i).getStudentId().equals(enroll.getStudentId()){
        isfound = true;
    }
}
if(isfound){
    System.out.println("Student record found!");
}
else{
     System.out.println("No match found!");
}