private swap (int pos1, int pos2) {
    //do some checking to ensure pos1 and pos2 exist here...
    int tmp = items_[pos1];
    items_[pos1] = items_[pos2];
    items_[pos2] = tmp;
}