public class JsonItems{

@SerializedName("id_toko")
@Expose
private String idToko;
@SerializedName("nama_toko")
@Expose
private String namaToko;
@SerializedName("pesan_toko")
@Expose
private String pesanToko;

public String getIdToko() {
return idToko;
}

public void setIdToko(String idToko) {
this.idToko = idToko;
}

public String getNamaToko() {
return namaToko;
}

public void setNamaToko(String namaToko) {
this.namaToko = namaToko;
}

public String getPesanToko() {
return pesanToko;
}

public void setPesanToko(String pesanToko) {
this.pesanToko = pesanToko;
}

}