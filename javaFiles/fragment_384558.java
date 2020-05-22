public Tree() {
    NID = "";
    taxonomia = "";
    plantado = "";
    diametro = "";
    altura = "";
    valoracion = "";
    latitud = "";
    longitud = "";
    jardin = "";
    imagen = "";
}

public String getNid() {return NID;}
public String getTaxomia() {return taxomia;}
public String getPlantado() {return plantado;}
public String getDiametro() {return diametro;}
public String getAltura() {return altura;}
public String getValoracion() {return valoracion;}
public String getLatitud() {return latitud;}
public String getLongitud() {return longitud;}
public String getJardin() {return jardin;}
public String getImagen() {return imagen;}

@Override 
public String toString() {
    return "Nid: " + NID + " Taxomia: " + taxomia + " Plantado: " + plantado + " Diametro: " + diametro + " Altura: " + altura + " Valoracion: " + valoracion + " Latitud: " + latitud + " Longitud: " + longitud + " Jardin: " + " Imagen: " + imagen;
}