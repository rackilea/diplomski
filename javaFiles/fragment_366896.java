@Entity(name = "KIWI_TABLE")
public class NewBeautifulKiwi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int KiwiId;
    private String Kiwi;
    private Image kiwiImage;

    public int getKiwiId() {
        return KiwiId;
    }

    public void setKiwiId(int KiwiId) {
        this.KiwiId = KiwiId;
    }

    public String getKiwi() {
        return Kiwi;
    }

    public void setKiwi(String Kiwi) {
        this.Kiwi = Kiwi;
    }

    public Image getKiwiImage() {
        return kiwiImage;
    }

    public void setKiwiImage(Image kiwiImage) {
        this.kiwiImage = kiwiImage;
    }
}