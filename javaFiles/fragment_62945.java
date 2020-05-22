Mat src = imread("in.jpg"), gray;

cvtColor(src, gray, CV_BGR2GRAY);

threshold(gray, gray, 230, 255, THRESH_BINARY_INV);

vector<Vec4i> hierarchy;
vector<vector<Point> > contours;

findContours(gray, contours, hierarchy, CV_RETR_LIST, CV_CHAIN_APPROX_SIMPLE);

gray = Scalar::all(255);
for (size_t i=0; i<contours.size(); i++)
{
    drawContours(gray, contours, i, Scalar(0), -1);
}

Mat element = getStructuringElement(MORPH_RECT, Size(2, 2), Point(1, 1));
dilate(gray, gray, element);
erode(gray, gray, element);

imshow("window", gray);