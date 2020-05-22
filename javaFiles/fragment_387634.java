abstract class Cow {
  Cow() throws Exception {
    ... // possible exceptions
  }
}

class FatCow extends Cow {
  FatCow() throws Exception {
    super();
    ...
  }
}

class GreenCow extends Cow {
  GreenCow() throws Exception {
    super();
    ...
  }
}

enum CowType {
  FAT_COW, GREEN_COW;
}

class CowMachine {
  static Cow makeCow(CowType type) {
    try {
      switch (type) {
        case FAT_COW:
          return new FatCow();
        case GREEN_COW:
          return new GreenCow();
        default:
          throw new IllegalArgumentException();
      }
    } catch (Exception e) {
      ...
      return null;
    }
  }

  static Cow makeFatCow() {
    return (FatCow) makeCow(CowType.FAT_COW);
  }

  static Cow makeGreenCow() {
    return (GreenCow) makeCow(CowType.GREEN_COW);
  }
}