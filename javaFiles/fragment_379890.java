public interface PullInterface {
    public void pullSlot();
}

public class GGCGuiLotto implements PullInterface {
    ArrayList<ImageIcon> slotList = new ArrayList<>();  // global scope.
    JLabel aReel1lbl = new JLabel();
    JLabel bReel2lbl = new JLabel();
    JLabel cReel3lbl = new JLabel();
    Random rand = new Random();

    public GGCGuiLotto() {
        GenPLCListener listener = new GenPLCListener(this);
    }

    @Override
    public void pullSlot() {
        // do what you need to do here to implement a pulling of the lever
        int r1 = rand.nextInt(slotList.size());
        int r2 = rand.nextInt(slotList.size());
        int r3 = rand.nextInt(slotList.size());

        reel1lbl.setIcon(slotList.get(r1));
    }
}

public class GenPLCListener implement ActionListener {
    private PullInterface pull;

    public GenPLCListener(PullInterface pull) {
        this.pull = pull;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pull.pullSlot();
    }
}