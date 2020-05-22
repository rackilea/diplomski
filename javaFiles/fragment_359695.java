s = biggerArray(s);
itab = new ArrayIterator(s);
int index = 0;
Student nowy =new Student("Małgorzata", "Kopytko", 165642, 4);
for (itab.first(); !itab.isDone(); itab.next()) {
    Student st = (Student) itab.current();
    if (st.nrIndex >nowy.nrIndex) {
        System.arraycopy(s, index, s, index + 1, 5 - index);
        s[index] = nowy;
        break;
    }
    index++;
}