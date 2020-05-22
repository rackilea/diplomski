//Make the list
Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray,
                  Color.green, Color.lightGray, Color.magenta, Color.magenta,
                  Color.orange, Color.pink, Color.red, Color.white, Color.yellow};

//Draw each rectangle
for (int x = 0; x < 10; x++) {

    //Change the color
    g.setColor(colors[x]);

    //Draw the rectangle
    graph2D.drawRect(170, (x * 45) + 180, 20, 50);
}