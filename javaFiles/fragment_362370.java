int[] colors = new int[] {
    ContextCompat.getColor(context, R.color.color_one),
    ContextCompat.getColor(context, R.color.color_two),
    ContextCompat.getColor(context, R.color.color_three),
    ContextCompat.getColor(context, R.color.color_four);
};

float[] positions = new float[] {
    0, 0.33, 0.67, 1
};

LinearGradient linearGradient = 
    new LinearGradient(0, 0, width, height, colors, positions, Shader.TileMode.REPEAT);