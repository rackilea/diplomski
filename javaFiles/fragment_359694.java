itab = new ArrayIterator(s);
    Student[] newArray = new Student[6];
    int newIndex = 0;
    Student nowy =new Student("Małgorzata", "Kopytko", 165642, 4);
    for (itab.first(); !itab.isDone(); itab.next()) {
        Student st = (Student) itab.current();
        if (st.nrIndex > nowy.nrIndex) { //Not sure about the meaning of this condition, make sure you only add the new student once!
            newArray[newIndex] = nowy;
            newIndex++;
        }
        newArray[newIndex] = st;
        newIndex++;
    }