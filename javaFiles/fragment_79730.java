correctedToBeOverridden(){
    processA(var1); 
    processB(var1); 
    processD(var2);
    processE(var2);
} 

@Override 
toBeOverridden() {
    correctedToBeOverridden();
}