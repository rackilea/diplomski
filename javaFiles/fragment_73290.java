public class Needy extends BaseCell {

    protected Needy(Parcel in) {
        super(in);
        cellType ="Needy";
    }

    // Since Needy doesn't actually store any variables, we don't need a Creator for it.
    // Just point it to BaseCell.CREATOR and let it handle it
    public static final Parcelable.Creator<BaseCell> CREATOR = BaseCell.CREATOR;

    public Needy(String imageUrl, int drawableID, String needyTitle, String needyDescription, int amountOfCollectedDonation, int amountOfTargetDonation, int amountOfDonater, String category, String campaignCode, int maxInstallmentNumber, int price) {
        super(imageUrl, drawableID, needyTitle, needyDescription, amountOfCollectedDonation, amountOfTargetDonation, amountOfDonater, category, campaignCode, maxInstallmentNumber,price);
        cellType = "Needy";
    }

}