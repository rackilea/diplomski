TreeSet<Pracownicy> set = new TreeSet<Pracownicy>();

Comparator<Pracownicy> surnameComparator = new Comparator<Pracownicy>() {

    @Override
    public int compare(Pracownicy o1, Pracownicy o2) {
        return o1.nazwisko.compareTo(o2.nazwisko);
    }
};

Comparator<Pracownicy> firstNameComparator = new Comparator<Pracownicy>() {

    @Override
    public int compare(Pracownicy o1, Pracownicy o2) {
        return o1.imie.compareTo(o2.imie);
    }
};

List<Pracownicy> list = new ArrayList<Pracownicy>(set);

// sort by surname
Collections.sort(list, surnameComparator);

// sort by first name
Collections.sort(list, firstNameComparator);