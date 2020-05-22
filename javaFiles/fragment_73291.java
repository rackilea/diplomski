public abstract class BaseCell implements Parcelable {

    /**
     * ALL OF YOUR VARIABLES, GETTERS, SETTERS AND CONSTRUCTORS GOES HERE
     */

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<BaseCell> CREATOR = new Parcelable.Creator<BaseCell>() {
        @Override
        public BaseCell createFromParcel(Parcel in) {
            String cellType = in.readString();
            if (cellType.equals("Needy")) {
                return (Needy)new Needy(in);
            } else if (cellType.equals("Qurban")) {
                return (Qurban)new Qurban(in);
            }
            return null;
        }

        @Override
        public BaseCell[] newArray(int size) {
            return new BaseCell[size];
        }
    };

    protected BaseCell(Parcel in) {
        drawableID = in.readInt();
        price = in.readInt();
        imageUrl = in.readString();
        needyTitle = in.readString();
        needyDescription = in.readString();
        category = in.readString();
        campaignCode = in.readString();
        maxInstallmentNumber = in.readInt();
        userPurchaseAmount = in.readInt();
    }

    public void writeToParcel(Parcel out, int flags) {
        // cellType written first, and read by Creator
        out.writeString(cellType);
        // the rest is read by the BaseCell constructor
        out.writeInt(drawableID);
        out.writeInt(price);
        out.writeString(imageUrl);
        out.writeString(needyTitle);
        out.writeString(needyDescription);
        out.writeString(category);
        out.writeString(campaignCode);
        out.writeInt(maxInstallmentNumber);
        out.writeInt(userPurchaseAmount);
    }

}