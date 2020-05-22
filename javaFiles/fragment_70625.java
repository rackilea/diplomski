private void transferStack(){
    if(StackOldest.isEmpty()){
        while(!StackNewest.isEmpty()){ // you forgot it here
            StackOldest.push(StackNewest.pop());
        }
    }
}