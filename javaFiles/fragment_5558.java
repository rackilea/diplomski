public Controller(Model model, String title, int xPos, int yPos) {

    // Record reference to the model
    this.model = model;
    this.title = getTitle();

    // Configure the window
    setTitle("Controller");
    setLocation(xPos, yPos);

    // Rest of the constructor...