float result = 1.0f;
int totalImages = 1000;
int displayedImages = 20;

for (int i = 0; i < displayedImages; i++) {
  result = result * (totalImages - displayedImages - i) / (totalImages - i);
}

System.out.println(result);