public enum Enum {
    person,
    people,
    people_baby,
    people_crowd,
    people_group,
    people_hand,
    people_many,
    people_portrait,
    people_show,
    people_tattoo,
    people_young;

    public static boolean hasTag(String tag) {
        for (Enum e : values()) {
            if (e.name().equals(tag))
                return true;
        }

        return false;
    }
}