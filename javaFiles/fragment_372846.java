int length=1;
int defLength=0;
int startIdx=0;
int defStartIdx=0;
int endIdx=0;
int defEndIdx=0;
// Needed in order not to override start index
boolean found = false;
if(efs[i] == efs[i-1]) {
    ++length;
    if(!found) {
        startIdx=i-1;
        found = true;
    }
 } else {
     if(found) {
            endIdx=i-1;
            found=false;
    }
    if(defLength < length) {
           defEndIdx = endIdx;
           defStartIdx = startIdx;
           found = false;
    }
}