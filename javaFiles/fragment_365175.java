int km = 0, luku = 0;

  do {
    System.out.println("Anna ajetut kilometrit (0 lopettaa): ");
    luku = lukija.nextInt();
    km = km + luku;
  } while (luku != 0);
  System.out.println("Yhteensä " + km + " kilometriä");