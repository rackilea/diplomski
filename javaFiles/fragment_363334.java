public String toString() {
   String s = "<HashTable[";
   int i = 0;
   int count = 0;
   while(count < this.size()) {

        //Skip the AVAILABLE cells
        if(data[i] == AVAILABLE) {
            i++;
            continue;
        }

        s += data[i].toString();
        if(count < this.size() - 1) {
            s += ",";
        }
        count++;
    }
    s += "]>";
    return s;
}