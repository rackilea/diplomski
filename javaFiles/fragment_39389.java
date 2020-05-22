try{//whatever}
catch(A ex){//do something specific for A}
catch(B ex){//do something specific for B}

try{//whatever}
catch(C ex){
 //C is superclass of A and B and you are not concerned about the specific type 
 // will catch even other exceptions which are instanceof C
}

try{//whatever}
catch(A|B ex){//do the same thing for both A and B}