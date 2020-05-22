boolean looping = true;
while (looping){
    int choice = scan.nextInt();
    //.... edit
    if (choice == 1){
         //Do your card/hand handling code here
    }
    //.... end of edit
    else if(choice == 2 || hand >= 22){
         looping = false;
         continue;  //Alternatively just break;
    }
}