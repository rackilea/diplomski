public static void main(String[] args) {
            ArrayList<Parking> parking = new ArrayList<Parking>();

            for (int i = 0; i < 15; i++) {
                parking.add(new Parking(String.valueOf(i + 1)));
            }
            for (Parking i: parking) {
                i.start();
            }
        }
}