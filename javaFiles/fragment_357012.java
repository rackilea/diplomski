Mat img = imread("Lenna.png");

Mat *image = &img;

Rect roi = Rect(100, 100, 100, 100);

Mat gray;
cvtColor((*image)(roi), gray, CV_RGB2GRAY);
Mat gray_3ch;
cvtColor(gray, gray_3ch, CV_GRAY2RGB);

gray_3ch.copyTo((*image)(roi));