for (int contourIdx = 0; contourIdx < questionSortedR.size(); contourIdx++) {
        //creating rectangle around identified contour
        Rect rectCrop = boundingRect(questionSortedR.get(contourIdx));
        //creating crop of that contour from actual image
        Mat imageROI= thresh.submat(rectCrop);
        //apply countnonzero method to that crop
        int total = countNonZero(imageROI);
        double pixel =total/contourArea(questionSortedR.get(contourIdx))*100;
        //pixel is in percentage of area that is filled
        if(pixel>=100 && pixel<=130){
            //counting filled circles
            count++;
        }

    }