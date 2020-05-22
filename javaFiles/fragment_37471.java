vector<Point> getQuadrilateral(Mat & grayscale, Mat& output)
{
    Mat approxPoly_mask(grayscale.rows, grayscale.cols, CV_8UC1);
    approxPoly_mask = Scalar(0);

    vector<vector<Point>> contours;
    findContours(grayscale, contours, RETR_EXTERNAL, CHAIN_APPROX_NONE);

    vector<int> indices(contours.size());
    iota(indices.begin(), indices.end(), 0);

    sort(indices.begin(), indices.end(), [&contours](int lhs, int rhs) {
        return contours[lhs].size() > contours[rhs].size();
    });

    /// Find the convex hull object for each contour
    vector<vector<Point> >hull(1);
    convexHull(Mat(contours[indices[0]]), hull[0], false);

    vector<vector<Point>> polygon(1);
    approxPolyDP(hull[0], polygon[0], 20, true);
    drawContours(approxPoly_mask, polygon, 0, Scalar(255));
    imshow("approxPoly_mask", approxPoly_mask);

    if (polygon[0].size() >= 4) // we found the 4 corners
    {
        return(polygon[0]);
    }

    return(vector<Point>());
}


int main(int argc, char** argv)
{

    Mat input = imread("papersheet1.JPG");
    resize(input, input, Size(), 0.1, 0.1);
    Mat input_grey;
    cvtColor(input, input_grey, CV_BGR2GRAY);
    Mat threshold1;
    Mat edges;
    blur(input_grey, input_grey, Size(3, 3));
    Canny(input_grey, edges, 30, 100);


    vector<Point> card_corners = getQuadrilateral(edges, input);
    Mat warpedCard(400, 300, CV_8UC3);
    if (card_corners.size() == 4)
    {
        Mat homography = findHomography(card_corners, vector<Point>{Point(warpedCard.cols, warpedCard.rows), Point(0, warpedCard.rows), Point(0, 0), Point(warpedCard.cols, 0)});
        warpPerspective(input, warpedCard, homography, Size(warpedCard.cols, warpedCard.rows));
    }

    imshow("warped card", warpedCard);
    imshow("edges", edges);
    imshow("input", input);
    waitKey(0);

    return 0;
}