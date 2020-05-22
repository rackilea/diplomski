Picture picture = new Picture();
    Canvas canvas = picture.beginRecording(300, 300);
    canvas.drawRect(new Rect(5, 5, 10, 10), new Paint()); // configure paint here
    picture.endRecording();

    picture.writeToStream(new FileOutputStream("stored_drawing.pict"));