// Read the image.

final InputStream is = new FileInputStream("Path\\To\\Image");
final Image img = new Image(is);

// Read through the pixels and count the number of occurrences of each color.

final PixelReader pr = img.getPixelReader();
final Map<Color, Long> colCount = new HashMap<>();

for(int x = 0; x < img.getWidth(); x++) {
  for(int y = 0; y < img.getHeight(); y++) {
    final Color col = pr.getColor(x, y);
    if(colCount.containsKey(col)) {
      colCount.put(col, colCount.get(col) + 1);
    } else {
      colCount.put(col, 1L);
    }
  }
}

// Get the color with the highest number of occurrences .

final Color dominantCol = colCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();