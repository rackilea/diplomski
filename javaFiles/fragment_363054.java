Random r = new Random();
  List<Integer> numbers = new ArrayList<>();
  int count = 0;

  private int getRandomImage() {
      int select;
      if (count < mImageIds.length) {
          select = r.nextInt(mImageIds.length);
          while(numbers.contains(select)) {
              select = r.nextInt(mImageIds.length);
          }
          numbers.add(select);
          count++;
          return mImageIds[select];
      }
      return -1;
  }