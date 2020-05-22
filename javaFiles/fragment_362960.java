for (int a = 0; a < list.length; a++) { //To Display all current Student Information.
    //   list[i] = new student();
    student student = list[a];
    if ( null == student ) {
       break;
    }
    else {
       list[a].DisplayOutput();
    }
}