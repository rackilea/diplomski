public NewsItem(Parcel in) {
    in.readInt();
    this.name = in.readString();
    this.bubble = in.readString();
    this.drawable = in.readString();
    this.title = in.readString();
    this.summary = in.readString();
    this.description = in.readString();
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.name);
    dest.writeString(this.bubble);
    dest.writeString(this.drawable);
    dest.writeString(this.title);
    dest.writeString(this.summary);
    dest.writeString(this.description);
}