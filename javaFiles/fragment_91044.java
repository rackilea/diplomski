@Override
public void writeToParcel(Parcel dest, int flags) {
   dest.writeString (name);
   dest.writeInt (ID);
   dest.writeDouble (molarMass);
   dest.writeString (symbol);
}

public Element(Parcel in) {
    name=in.readString();        
    ID=in.readInt();
    molarMass=in.readDouble();
    symbol=in.readString(); // <- move this to the end
}