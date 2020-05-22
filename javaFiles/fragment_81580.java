@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.operationType.name());
    dest.writeInt(this.digitCount);
    dest.writeByte((byte) (this.timerEnabled ? 1 : 0));
}