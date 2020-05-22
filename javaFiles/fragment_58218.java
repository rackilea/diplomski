public CurrentWeatherCardView(Context context) {
    super(context);
    init();
}

public CurrentWeatherCardView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
}

public CurrentWeatherCardView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init();
}

private void init() { 
    LayoutInflater.from(this).inflate(R.layout.xxx, this, true);
    xxx = findViewById(R.id.xxxxx);
    ...
    xxx.setText(xxxx)

    // if you want to change visibility, just call:
    setVisibility(View.GONE/View.VISIBILE);
}