public class SerialPublication {

    public enum Frequency {
        //Can add extra information to enums
        DAILY("Daily"),
        WEEKLY("Weekly"),
        MONTHLY("Monthly"),
        QUARTERLY("Quarterly"),
        YEARLY("Yearly"),
        UNDEFINED("Undefined");

        private final String frequency;

        Frequency(String frequency) {
            this.frequency = frequency;
        }

        public String getFrequency() {
            return frequency;
        }

        /**
         * Builds an enum from a given frequency string
         * @param aFrequency
         * @return
         */
        public static Frequency fromString(String aFrequency) {
            for (Frequency frequency : Frequency.values()) {
                if(frequency.getFrequency().toLowerCase().equals(aFrequency.toLowerCase())) {
                    return frequency;
                }
            }
            return Frequency.UNDEFINED; //Could send null back
        }
    }

    private Frequency frequency;

    public SerialPublication(){
        frequency = Frequency.UNDEFINED;
    }

    public SerialPublication(String freq){
        this.setFrequency(freq);
    }

    /**
     * Sets the frequence based on a String. This handles invalid input by assuming nonsense equals undefined
     * @param frequency
     */
    public void setFrequency(String frequency){
        this.setFrequency(Frequency.fromString(frequency));
    }

    /**
     * Sets the frequency based on the Frequency Enum.
     * @param frequency
     */
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Frequency getFrequency(){
        return frequency;
    }

    public static void main(String[] args) {
        SerialPublication publication = new SerialPublication();
        System.out.println(publication.getFrequency());
        publication.setFrequency("monthly");
        System.out.println(publication.getFrequency());
        publication.setFrequency(Frequency.QUARTERLY);
        System.out.println(publication.getFrequency());
        publication.setFrequency("cows are great");
        System.out.println(publication.getFrequency());
    }
}