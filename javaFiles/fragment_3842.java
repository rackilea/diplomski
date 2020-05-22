enum Weather {
    RAINY, SUNNY, STORMY;

    @Override
    public String toString() {
        return String.valueOf(hashCode());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(EnumUtils.getStringValues(Weather.class)));
        System.out.println(Arrays.toString(EnumUtils.getStringValuesWithStringExtractor(Weather.class, Weather::toString)));
    }

}