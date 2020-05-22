public void renderObject(GraphicsContext playGraphics, Canvas toUpdate)
{       
    if (!Platform.isFxApplicationThread())
    {
        throw new IllegalStateException(
            "Must be called in JavaFX application thread");
    }

    String[] toAppend = {
        "M 215 256", "L 215 256", "L 215 256", "L 215 256",
        "L 225 241", "L 234 231", "L 246 223", "L 266 214",
        "L 284 208", "L 309 204", "L 340 200", "L 378 199",
        "L 416 199", "L 444 199", "L 473 203", "L 485 206",
        "L 496 211", "L 506 218", "L 510 224", "L 513 233",
        "L 515 243", "L 516 257", "L 512 270", "L 502 285",
        "L 493 298", "L 483 308", "L 476 315", "L 472 318",
        "L 469 320", "L 468 320", "L 468 320", "L 468 320",
        "L 468 317", "L 472 309", "L 480 300", "L 492 293",
        "L 510 287", "L 535 283", "L 557 282", "L 580 283",
        "L 593 287", "L 607 295", "L 623 311", "L 634 333",
        "L 640 355", "L 642 396", "L 639 430", "L 624 467",
        "L 602 508", "L 582 536", "L 557 563", "L 524 585",
        "L 490 602", "L 464 611", "L 432 619", "L 420 621",
        "L 404 622", "L 393 622", "L 383 621", "L 376 620",
        "L 372 618", "L 365 610", "L 360 598", "L 358 578",
        "L 357 554", "L 361 514", "L 371 493", "L 386 463",
        "L 412 422", "L 432 395", "L 456 362", "L 480 329",
        "L 506 299", "L 533 271", "L 560 247", "L 600 213",
        "L 620 194", "L 626 189", "L 629 184", "L 630 182",
        "L 632 178"
    };

    // If the SVG string is not hard-coded, create the array here:
    // String[] toAppend = svgString.split(";");

    Runnable pathBuilder = () -> {
        try
        {
            StringBuilder path = new StringBuilder();

            for (String segment : toAppend)
            {
                Thread.sleep(100);

                path.append(" ").append(segment);
                String pathToDraw = path.toString();

                Platform.runLater(() -> {
                    playGraphics.beginPath();
                    playGraphics.appendSVGPath(pathToDraw);
                    playGraphics.stroke();
                });
            }
        }
        catch (InterruptedException e)
        {
            // Someone wants us to exit, so fall through and return.
            e.printStackTrace();
        }
    };

    Thread pathBuildingThread = new Thread(pathBuilder);
    pathBuildingThread.setDaemon(true);
    pathBuildingThread.start();
}