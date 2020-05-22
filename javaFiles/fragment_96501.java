public class Slider
{
    private static Activity context;
    private static int Duration = 3000;

    private Slider(SliderBuilder builder) {
        this.context = builder.context;
        this.Duration = builder.Duration;
    }

    //All getter, and NO setter to provde immutability
    public String getContext() {
        return context;
    }
    public String getDuration() {
        return Duration;
    }

    public static SliderBuilder with(Activity context){
        return new SliderBuilder(context);
    }

    public static class SliderBuilder
    {
        private static Activity context;
        private static int Duration = 3000;

        public SliderBuilder(Activity context) {
            this.context = context;
        }
        public SliderBuilder duration(int Duration) {
            this.Duration = Duration;
            return this;
        }
        //Return the finally constructed Slider object
        public Slider build() {
            Slider slider =  new Slider(this);
            validateSliderObject(slider);
            return slider;
        }
        private void validateSliderObject(Slider slider) {
            //Do some basic validations to check
        }
    }
}