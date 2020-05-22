Iterator<MyList> i = list.iterator();
while (i.hasNext()) {
    MyList ls = i.next();

    //... all your other code which uses ls...

    i.remove();
}