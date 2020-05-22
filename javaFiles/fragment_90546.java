for (int i = 0; i < list.size(); ) {
    MyElement element = list.get(i);
    if (element.getMyProperty()) {
        list.remove(i);
    } else {
        i++;
    }
}