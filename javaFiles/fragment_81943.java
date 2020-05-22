// setup a  cascade classifier:
CascadeClassifier cascade;

// load a pretrained cascadefile(and PLEASE CHECK!):
bool ok = cascade.load("haarcascade_frontalface_alt.xml");
if ( ! ok ) 
{
    ...
}


// later, search for stuff in your img:
Mat gray; // uchar grayscale!
vector<Rect> faces; // the result vec

cascade.detectMultiScale( gray, faces, 1.1, 3, 
    CV_HAAR_FIND_BIGGEST_OBJECT | CV_HAAR_DO_ROUGH_SEARCH  ,
    cv::Size(20, 20) );

for ( size_t i=0; i<faces.size(); i++ )
{
// gray( faces[i] ); is the img portion that contains the detected object
}