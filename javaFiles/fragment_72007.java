@Override
public int compareTo(Student s) {
    int c1 = this.compare(this.name, s.name);
    if (c1 != 0) {
        return c1;
    } else {
        int c2 = this.compare(this.age, s.age);
        if (c2 != 0) {
            return c2;
        } else {
            return this.compare(this.classStudy, s.classStudy);
        }
    }
}

public int compare(String s1, String s2) {
    if (s1 == null && s2 == null) {
        return 0;
    } else if (s1 == null) {
        return -1;
    } else if (s2 == null) {
        return 1;
    } else {
        return s1.compareTo(s2);
    }
}