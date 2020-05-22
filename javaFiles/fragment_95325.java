Drawcirlce myCircle = new Drawcirlce();
if (flag == true)
    myCircle.myPaint = new Paint(paint); // Copies the current paint object.
else
    myCircle.myPaint = new Paint(p2); // Copies the current p2 object.
dc.add(); // Adds our circle with its own Paint object.