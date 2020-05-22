public int compareTo(Object o) {
    if (name.compareTo(((AccountOwnerComparable) o).name) > 0) {
        System.out.println("Greater");
        return -1;
    } else if (name.compareTo(((AccountOwnerComparable) o).name) < 0) {
        System.out.println("Lesser");
        return 1;
    } else {
        System.out.println("Equal");
        return 0;
    }

}