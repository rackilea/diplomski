Collections.sort(colors, new Comparator<Color>() {
        @Override
        public int compare(Color c1, Color c2) {
            return Float.compare(((float) c1.getRed() * 0.299f + (float) c1.getGreen() * 0.587f
                    + (float) c1.getBlue() * 0.114f) / 256f, ((float) c2.getRed() * 0.299f + (float) c2.getGreen()
                    * 0.587f + (float) c2.getBlue() * 0.114f) / 256f);
        }
    });