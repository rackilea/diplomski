public void startColorAnimation (int id) {

    MainActivity.this.runOnUiThread (new Runnable () {
        public void run () {
            if (id == mode) return;
            if (COLOR_START.length <= id || COLOR_END.length <= id) return;
            mode = id;
            int colorStart = COLOR_START[id];
            int colorEnd = COLOR_END[id];
            int setDuration = PATTERN[id];


            ValueAnimator colorAnim = ObjectAnimator.ofInt (image, "backgroundColor", colorStart, colorEnd);
            colorAnim.setDuration (1000);
            colorAnim.setEvaluator (new ArgbEvaluator ());
            colorAnim.setRepeatCount (1);
            colorAnim.start ();
        }
    });
}