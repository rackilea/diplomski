public class PlayGround {

    int value = 3;

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        PlayGround.PlayGroundSon pg = new PlayGround().new PlayGroundSon();
        System.out.println("value is "+pg.getValue());
    }

    class PlayGroundSon extends PlayGround{

        int sonValue = 5;

        @Override
        public int getValue() {
            return sonValue;
        }
    }
}