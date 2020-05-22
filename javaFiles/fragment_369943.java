for(int i = 0; i < list.size(); ++i) {
    final MyClass curr = list.get(i);
    for(int j = 0; j < list.size(); ++j) {
        if(i != j) {
            curr.conflictsWith(list.get(j));
        }           
    }
}