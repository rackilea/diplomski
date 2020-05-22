for (int i = 0; i < (leaf.length-1) ; i++) { 
    for (int j = 0; j < leaf.length; j++) { // Should be j < leaf.length - 1
        if(leaf[j].frequency<leaf[j+1].frequency){
            temp=leaf[j];
            leaf[j]=leaf[j+1];
            leaf[j+j]=temp;  // RIGHT HERE, should be leaf[j + 1]
        }
    }
}