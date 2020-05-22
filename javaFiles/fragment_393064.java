String line;
while ((line = kbd.readLine()) != null) {
    String dvdTitle = line;
    String dvdCategory = kbd.readLine();
    String dvdRunningTime = kbd.readLine();
    int dvdYear = Integer.parseInt(kbd.readLine());
    double dvdPrice = Double.parseDouble(kbd.readLine());

    DVDArrayList.add(new DVD(dvdTitle, dvdCategory, dvdRunningTime, dvdYear, dvdPrice));
}
DVDArrayList.stream().forEach(System.out::println);