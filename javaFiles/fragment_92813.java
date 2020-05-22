void sort(List list) {
    if (list fits in memory) {
        list.sort();
    } else {
        sublists = partition list into k about equally big sublists
        for (sublist : sublists) {
            sort(sublist);
        }
        merge(sublists);
    }
}

void merge(List[] sortedsublists) {
    keep a pointer in each sublist, which initially points to its first element
    do {
        find the pointer pointing at the smallest element
        add the element it points to to the result list
        advance that pointer
    } until all pointers have reached the end of their sublist
    return the result list
}