public int getSum() {

    return (int) getVerkaufArtikels()
            .stream()
            .mapToDouble(acc -> ((double) acc.getPreispro() * acc.getAnz()))
            .sum();
}