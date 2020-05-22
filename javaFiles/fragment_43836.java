@Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeDouble(distanza);
        parcel.writeInt(numero_commenti);
        parcel.writeDouble(valutazione);
        parcel.writeList(cordinate);
    }