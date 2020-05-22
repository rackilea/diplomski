while (rs.next()) {
    DetailCaisse detailCaisse = new DetailCaisse();

    Devise devise = new Devise(); // Here!
    devise.setLibSiglDev(rs.getString("LIB_DEV_DEV"));
    devise.setLibSiglDev(rs.getString("LIB_SIGL_DEV"));
    devise.setCodDevDev(rs.getInt("cod_Dev_dev"));

    detailCaisse.setDevise(devise);

    deviseDispo.add(detailCaisse);
}