public class RoomTipologyMockFactory {

    private enum RoomTipologyEnum {
        MATRIMONIALE,
        MATRIMONILAE_SUPERIOR,
        QUADRUPLA,
        TRIPLA,
        SINGOLA;

        private static final List<RoomTipologyEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        private static List<Object> randomRoomTipology;

        public static RoomTipologyEnum getRandomRoomTipologyValue()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }

    }

    public static RoomTipology getRandomRoomTipology() {
        RoomTipologyEnum roomTipologyEnum = RoomTipologyEnum.getRandomRoomTipologyValue();
        RoomTipology result = new RoomTipology();
        switch (roomTipologyEnum) {
            case MATRIMONIALE:
                break;
            case MATRIMONILAE_SUPERIOR:
                break;
            case QUADRUPLA:
                break;
            case TRIPLA:
                break;
            case SINGOLA:
                break;
        }
        return result;
    }

}