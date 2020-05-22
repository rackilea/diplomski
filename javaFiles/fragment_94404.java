public static Shape parse(String shape_data) {
    Shape shape;

    // TODO: complete this method
    String[] parts = shape_data.split(" ");
    switch(parts[0])
    {
        case "rectangle":
        shape = new Rectangle(parts[1], parts[2], parts[3]);
        break;
       etc...
    }
    return shape;
}