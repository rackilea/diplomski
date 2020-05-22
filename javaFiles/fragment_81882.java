public int compareTo(MyOwnString cts){
    int word1Length = ((MyOwnString)this).data.length;
    int word2Length = cts.data.length;
    for (int i=0; i < Math.min(word1Length,word2Length); i++){
        if(this.data[i] == cts.data[i]){
            continue;
        }
        else if (this.data[i] > cts.cts[i]){
            return -1;
        }
        else if (this.data[i] < cts.cts[i]) {
            return 1;
        }
    }
    if (word1Length == word2Length){
        return 0;
    }
    else if(word1Length < word2Length){
        return 1;
    }
    else {
        return -1;
    }
}

public boolean equals(MyOwnString cts){
    int word1Length = ((MyOwnString)this).data.length;
    int word2Length = cts.data.length;
    if (word1Length != word2Length){
        return false;
    }
    else { // if they are equal
        int comparison = this.compareTo(cts);
        if (comparison==0){
            return true;
        }
        else {
            return false;
        }
    }
}