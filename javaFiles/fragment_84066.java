public static void main(String[] args) {
        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film(100));
        films.add(new Film(400));
        films.add(new Film(200));
        films.add(new Film(300));
        /*reverse order is the reversed order of your compareTo method
         , as you need Decreasing manner and the compareTo method
          outputs the Increasing manner then you need to reverse it,
          remove this comparator if you need it increasing.*/
        Collections.sort(films,Comparator.reverseOrder());
    for (Film film : films) {
        System.out.print(film.finalScore+" "); // prints 400 300 200 100
       }     
    }