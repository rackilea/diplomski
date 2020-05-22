double columnWidth = 0.105;
        double columnCount = Math.sqrt(input);
        double sieveWidth = columnCount * columnWidth;
        double sieveHeight = sieveWidth;
        double sieveTop = 0.95;
        double sieveLeft = 0.045;
        double padding = 0.15;

        StdDraw.setXscale(sieveLeft - padding, sieveLeft + sieveWidth + padding);
        StdDraw.setYscale(sieveTop - sieveHeight - padding, sieveTop + padding);