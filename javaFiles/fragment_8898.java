public enum Horse {
    THREE_LEG_JOE, GLUE_FACTORY
};

public static void main(String[] args) {
    System.out.println(searchEnum(Horse.class, "Three_Leg_Joe"));
    System.out.println(searchEnum(Day.class, "ThUrSdAy"));
}