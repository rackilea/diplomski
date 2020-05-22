void main() {
    load(image1);
    load(image2);
    load(image3);
}
void load(image) {
    try {
       loadFile(image);
    }
    catch {
      loadFile(default);
    }
}