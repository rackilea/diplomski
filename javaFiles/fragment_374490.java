float hue = your_color/255; // if you want to use 0-255 range

        for (int i = 0; i < N; i++) {                 
            clut.add(Color.getHSBColor(hue, 1 - (i / N), 1));             
        }             
        for (int i = 0; i < N; i++) {                 
            clut.add(Color.getHSBColor(hue, i / N, 1));             
        }