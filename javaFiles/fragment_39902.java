class Controller {
  Window window;
  void closeWindow() {
    window.close(); // drops image (optional)
    window = null;  // frees object reference
  }
}