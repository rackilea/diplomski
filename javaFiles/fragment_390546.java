list.add(new Music("Justin Timberlake", "Cry me a river", 2003, 4, "Pop")
list.add(new Music("Mariah Carey", "One sweet day", 1996, 2, "R&B")

//sorting list
Collections.sort(list, new Comparator<Music>() {
    public int compare(Music one, Music two) {
        return one.getYear().compareTo(two.getYear()); //by year
    }
});

//now see the result
for(Music m: list)
    System.out.println(m.toString());