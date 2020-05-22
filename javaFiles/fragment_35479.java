// Prepare memory for the output
int width=4;
int height=3;

int[][] d2 = new int[height][width];

try {
    BufferedReader br = new BufferedReader(new FileReader("test.txt"));
    String fileContent = "";
    String line;

    while ((line = br.readLine()) != null) {
      fileContent += line + " ";
    }

    String ints[] = fileContent.split("\\p{javaWhitespace}+");

    for(int i=0;i<height;i++) {
      for (int j = 0; j < width; j++) {
        if((i * width + j) >= ints.length) throw new RuntimeException("Not enough ints :-(");
        d2[i][j] = Integer.parseInt(ints[i * width + j]);
      }
    }
} catch (Exception e) {
  e.printStackTrace();
}

/// Now you have the 2d_array in d2!