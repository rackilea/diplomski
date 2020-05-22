for(int m=0; m<personelList.size(); m++) {
    Personel personel = personelList.get(m);
    data[m] = new Object[]{
              personel.getPersonelAdSoyad(),
              personel.getUnvanID().getUnvanAdi()
    };
}