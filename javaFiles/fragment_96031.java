int count = 0;

while (count <= numOfLiter) {
    Double total = pricePerLitre * count;
    System.out.println("Liter " + count + ": " + total);

    count++;
}