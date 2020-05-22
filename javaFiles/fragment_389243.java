private static void getQuadrantsColorAverages(Color[] quadrantColors, BufferedImage img) {
    // Decalre and Initialize required variables.
    BufferedImage wrkImg = img;
    BufferedImage blockImg = null; //?????
    int imgWidth = wrkImg.getWidth();
    int imgHeight = wrkImg.getHeight();
    int startHeight = 0;
    int endHeight = 0;
    int startWidth = 0;
    int endWidth = 0;
    Color oldAvg = null;
    int quadCount = 1;

    // Start our loop and and continue it until our counter 
    // variable named quadCount goes over 20....
    while (quadCount <= 20) {
        // Handle dissectional dimensions (in pixels)
        // for quadrants 1 to 20 as layed out within
        // the supplied image to this forum post.
        switch (quadCount) {
            // Quadrant 1
            case 1:
                startHeight = 0; endHeight = (imgHeight / 2);
                startWidth = 0; endWidth = (imgWidth / 2);
            // Quadrant 2
            case 2: 
                startWidth = (endWidth + 1); endWidth = imgWidth; 
                break;
            // Quadrant 3
            case 3: 
                startHeight = (endHeight + 1); endHeight = imgHeight;
                startWidth = 0; endWidth = (imgWidth / 2);
                break;
            // Quadrant 4
            case 4:
                startWidth = (endWidth + 1); endWidth = imgWidth; 
                break;
            // Quadrant 5
            case 5:
                startHeight = 0; endHeight = (imgHeight / 4);
                startWidth = 0; endWidth = (imgWidth / 4);
                break;
            // Quadrant 6
            case 6:
                startWidth = (endWidth + 1); endWidth = (imgWidth / 2);
                break;
            // Quadrant 7
            case 7:
                startHeight = (endHeight + 1); endHeight = (imgHeight / 2);
                startWidth = 0; endWidth = (imgWidth / 4);
                break;
            // Quadrant 8
            case 8:
                startWidth = (endWidth + 1); endWidth = (imgWidth / 2);
                break;
            // Quadrant 9
            case 9:
                startHeight = 0; endHeight = (imgHeight / 4);
                startWidth = (endWidth + 1); endWidth = ((imgWidth / 4) * 3);
                break;
            // Quadrant 10
            case 10:
                startWidth = (endWidth + 1); endWidth = imgWidth;
                break;
            // Quadrant 11
            case 11:
                startHeight = (imgHeight / 4); endHeight = (imgHeight / 2);
                startWidth = (imgWidth / 2); endWidth = ((imgWidth / 4) * 3);
                break;
            // Quadrant 12
            case 12:
                startWidth = (endWidth + 1); endWidth = imgWidth;
                break;
            // Quadrant 13
            case 13:
                startHeight = (imgHeight / 2); endHeight = ((imgHeight / 4) * 3);
                startWidth = 0; endWidth = (imgWidth / 4);
                break;
            // Quadrant 14
            case 14:
                startWidth = (endWidth + 1); endWidth = (imgWidth / 2);
                break;
            // Quadrant 15
            case 15:
                startHeight = (endHeight + 1); endHeight = imgHeight;
                startWidth = 0; endWidth = (imgWidth / 4);
                break;
            // Quadrant 16
            case 16:
                startWidth = (endWidth + 1); endWidth = (imgWidth / 2);
                break;
            // Quadrant 17
            case 17:
                startHeight = (imgHeight / 2); endHeight = ((imgHeight / 4) * 3);
                startWidth = (imgWidth / 2); endWidth = ((imgWidth / 4) * 3);
                break;
            // Quadrant 18
            case 18:
                startWidth = (endWidth + 1); endWidth = imgWidth;
                break;
            // Quadrant 19
            case 19:
                startHeight = (endHeight + 1); endHeight = imgHeight;
                startWidth = (imgWidth / 2); endWidth = ((imgWidth / 4) * 3);
                break;
            // Quadrant 20
            case 20:
                startWidth = (endWidth + 1); endWidth = imgWidth;
                break;
        }

        // Maintain the oldAvg Color variable
        oldAvg = getBlockAverage(startHeight, endHeight, startWidth, 
                                 endWidth, img, blockImg, oldAvg);
        // We subtract 1 from quadCount below to accomodate
        // our Array indexing which must start at 0.
        quadrantColors[quadCount - 1] = oldAvg;
        // increment our quadrant counter by 1.
        quadCount++;
    }
}