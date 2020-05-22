protected Percorso(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        distanza = in.readDouble();
        numero_commenti = in.readInt();
        valutazione = in.readDouble();
        cordinate = new ArrayList<Cordinate>();
        in.readList(cordinate,Cordinate.class.getClassLoader());
    }