for(int i = 0; i < list.size(); ++i) {
    final MyClass curr = list.get(i);
    for(int j = i + 1; j < list.size(); ++j) {
        curr.conflictsWith(list.get(j));
    }
}