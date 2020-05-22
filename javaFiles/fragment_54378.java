for (int m = 0; m < ogrenciSayisi; m++) {
    for (int j = 0; j < DersSayisi; j++) {
        System.out.println("Lütfen " + DersSayisi + ". dersin vize notunu giriniz : ");
        VizeNot = Scan.nextInt();
        ogrenci1.setVizeNotu(VizeNot);
        System.out.println("Lütfen " + DersSayisi + ". final notunu giriniz : ");
        FinalNot = Scan.nextInt();
        ogrenci1.setFinalNotu(FinalNot);
    }
}