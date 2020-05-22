class Student implements Comparable<Student>{
//variables constructor methods go here
private index;
@Override
public int compareTo(Students s) {
    int index = s.index;
    if (this.index > index) {
        return 1;
    } else if (this.index == index) {
        return 0;
    } else {
        return -1;
    }
}