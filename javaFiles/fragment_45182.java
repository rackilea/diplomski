int canvasWidth = canvas.getWidth();
    int canvasHeight = canvas.getHeight();

    int squareWidth = canvasWidth / NUMBER_OF_HORIZONTAL_SQUARES;
    int squareHeight = canvasHeight / NUMBER_OF_VERTICAL_SQUARES;
    Rect destinationRect = new Rect();

    int xOffset;
    int yOffset;

    // Set the destination rectangle size
    destinationRect.set(0, 0, squareWidth, squareHeight);

    for (int horizontalPosition = 0; horizontalPosition < NUMBER_OF_HORIZONTAL_SQUARES; horizontalPosition++){

        xOffset = horizontalPosition * squareWidth;

        for (int verticalPosition = 0; verticalPosition < NUMBER_OF_VERTICAL_SQUARES; verticalPosition++){

            yOffset = verticalPosition * squareHeight;

            // Set the destination rectangle offset for the canvas origin
            destinationRect.offsetTo(xOffset, yOffset);

            // Draw the bitmap into the destination rectangle on the canvas
            canvas.drawBitmap(bitmapArray[horizontalPosition][verticalPosition], null, destinationRect, null);
        }
    }