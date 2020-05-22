import android.os.Parcel;

import android.os.Parcelable;

public class TabooCard implements Parcelable {


    public static final Parcelable.Creator<TabooCard> CREATOR = new Parcelable.Creator<TabooCard>()
    {
        @Override
        public TabooCard createFromParcel(Parcel source)
        {
            return new TabooCard(source);
        }

        @Override
        public TabooCard[] newArray(int size)
        {
            return new TabooCard[size];
        }
    };

    String mainWord, taboo1, taboo2, taboo3, taboo4, taboo5;

    public TabooCard() {
        this("Main Card", "Taboo 1", "Taboo 2", "Taboo 3", "Taboo 4", "Taboo 5");
    }

    public TabooCard(String mainword, String taboo1, String taboo2, String taboo3, String taboo4, String taboo5) {
        setMainWord(mainword);
        setTaboo1(taboo1);
        setTaboo2(taboo2);
        setTaboo3(taboo3);
        setTaboo4(taboo4);
        setTaboo5(taboo5);
    }

    public TabooCard(Parcel in) {
        setMainWord(in.readString());
        setTaboo1(in.readString());
        setTaboo2(in.readString());
        setTaboo3(in.readString());
        setTaboo4(in.readString());
        setTaboo5(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mainWord);
        dest.writeString(taboo1);
        dest.writeString(taboo2);
        dest.writeString(taboo3);
        dest.writeString(taboo4);
        dest.writeString(taboo5);
    }