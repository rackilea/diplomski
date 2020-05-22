boolean pairFound = false;
int pairValue = Integer.MIN_VALUE;  
//or some value that arrayOfInts will never have based on context

for(int s = 0; s < arrayOfInts.length - 1; s++){
    if(arrayOfInts[s] == pairValue) { 
        continue; 
    }
    for(int c = s + 1; c < arrayOfInts.length; c++){
        if(arrayOfInts[s] == arrayOfInts[c]) {
            if(arrayOfInts[s] != pairValue) {
                if(pairFound) {    
                    return true;
                }
                pairValue = arrayOfInts[s];
                pairFound = true;
                break;
            }
        }
    }
}
return false;