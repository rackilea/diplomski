//first uniquely name the algorithms to compare (here just getY_TypeA and getY_TypeB)
double durationA = cv::getTickCount();

getY_TypeA(image); // the function to be tested

durationA = cv::getTickCount()-durationA;
durationA /= cv::getTickFrequency(); // the elapsed time in ms

//now call the other method

double durationB = cv::getTickCount();

getY_TypeB(image); // the function to be tested

durationB = cv::getTickCount()-durationB;
durationB /= cv::getTickFrequency(); // the elapsed time in ms

printf("Type A runtime: "+durationA+" Type B runtime: "+durationB);