String bs = "";
int count = 0;
for (int i = 0; i < size; i++) {
    if(!s[i].equals(0.0)) {
        if(count > 0) {
            bs += " ; " ;
        }
        bs += "S" + count + ":" + s[i].split(".")[0];
        count++;
    }

}