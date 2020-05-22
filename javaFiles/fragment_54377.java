public Ogrenci(String ogrenciNo, String ogrenciAd, String ogrenciSoyad, int dersSayisi) {
    this.ogrenciNo = ogrenciNo;
    this.ogrenciAd = ogrenciAd;
    this.ogrenciSoyad = ogrenciSoyad;
    dersNot = new int[dersSayisi][3]; // I assumed that 2 midterm exam(vize) 1 final exam
}