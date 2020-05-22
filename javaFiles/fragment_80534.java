class StudentDateComparator implements Comparator<StudentInformation> {
    public int compare(StudentInformation s1, StudentInformation s2) {
        return Integer.compare(s2.getBirthYear(), s1.getBirthYear());
    }
}

ArrayList<StudentInformation> infos = new ArrayList<StudentInformation>();
// fill array
Collections.sort(infos, new StudentDateComparator());