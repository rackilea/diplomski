// Reset values at each iteration
largest_area = 0;
largest_contour_index = -1;

for(int i = 0;i<contours.size();i++){
    double area = Imgproc.contourArea(contours.get(i));

    if(area > largest_area){
        largest_area = area;
        largest_contour_index = i;          
    }
}

// Draw only if index is valid
if(largest_contour_index >= 0) {
     bounding_rect = Imgproc.boundingRect(contours.get(largest_contour_index));
     Imgproc.drawContours(img_rgb,contours,largest_contour_index, new Scalar(0,255,0),2);
}