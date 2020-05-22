int addMarks1=Marks1[0],addMarks2=Marks2[0]; // initialize the sums of the first group
for(int i=0;i<sl_no.length-1;i++){
    if(Marks1[i]== Marks1[i+1] && Marks2[i]==Marks2[i+1]) {
        // add to the current group
        addMarks1=addMarks1+Marks1[i+1];
        addMarks2=addMarks2+Marks2[i+1];
    } else {
        // print the previous group and start a new group
        System.out.println(sl_no[i] + " " + addMarks1 + " " + addMarks2);
        addMarks1=Marks1[i+1];
        addMarks2=Marks2[i+1];
    }
}
// print the last group
System.out.println(sl_no[sl_no.length-1] + " " + addMarks1 + " " + addMarks2)