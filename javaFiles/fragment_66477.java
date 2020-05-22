public static final Parcelable.Creator<WebSiteObject> CREATOR = new Parcelable.Creator<WebSiteObject>() {
        public WebSiteObject createFromParcel(Parcel in) {
            return new WebSiteObject(in);
        }

        public WebSiteObject[] newArray(int size) {
            return new WebSiteObject[size];
        }
    };