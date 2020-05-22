// Store the color objects in an array
    int total_pixels = (h * w);
    Color[] colors = new Color[total_pixels];
    int i = 0;

    for (int x = 0; x < w; x++)
    {
      for (int y = 0; y < h; y++)
      {
        colors[i] = new Color(image.getRGB(x, y));
        i++;
      }
    }

// Later you can retrieve them
    for (int i = 0; i < total_pixels; i++)
    {
      Color c = colors[i];
      int r = c.getRed();
      int g = c.getGreen();
      int b = c.getBlue();
      System.out.println("Red" + r + "Green" + g + "Blue" + b);
    }