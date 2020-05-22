private static final Map<Integer, MsgEnum> INT_TO_ENUM = new HashMap<Integer, MsgEnum>();

static {
    for (MsgEnum msgE : MsgEnum.values) {
        INT_TO_ENUM.put(msgE.getNumber(), msgE);
    }
}

public static MsgEnum getByInt(int number) {
    return INT_TO_ENUM.get(number);
}