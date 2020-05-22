cv::Mat input = cv::imread("../inputData/Lenna.png");

    cv::Mat inputBGRA;
    cv::cvtColor(input, inputBGRA, CV_BGR2BGRA);

    cv::Mat gridSolid = cv::Mat(input.size(), inputBGRA.type(), cv::Scalar(0,0,0,0));
    cv::Mat gridMask = cv::Mat(input.size(), CV_8UC1, cv::Scalar(0));

    cv::Mat gridAlpha = cv::Mat(input.size(), inputBGRA.type(), cv::Scalar(0,0,0,0));


    cv::line(gridSolid, cv::Point(0,0), cv::Point(512,512), cv::Scalar(0,255,0,255), 10);
    cv::line(gridSolid, cv::Point(0,512), cv::Point(512,0), cv::Scalar(0,255,0,255), 10);
    cv::line(gridMask, cv::Point(0,0), cv::Point(512,512), cv::Scalar(255), 10);    // single channel
    cv::line(gridMask, cv::Point(0,512), cv::Point(512,0), cv::Scalar(255), 10);    // single channel

    // copy and use the mask. copying eliminates the original values where the mask is set
    cv::Mat outputCopy = inputBGRA.clone();
    gridSolid.copyTo(outputCopy,gridMask);



    // here set the scalar alpha value to less than 255
    // both lines use different alpha values
    cv::line(gridAlpha, cv::Point(0,0), cv::Point(512,512), cv::Scalar(0,255,0,120), 10);
    cv::line(gridAlpha, cv::Point(0,512), cv::Point(512,0), cv::Scalar(0,255,0,180), 10);

    cv::Mat outputWeightSum = inputBGRA.clone();
    //cv::addWeighted(inputBGRA, 0.5, gridAlpha, 0.5, 0, outputWeightSum);

    // manually add weighted sum PER ALPHA VALUE:
    for(int y=0; y<outputWeightSum.rows; ++y)
        for(int x=0; x<outputWeightSum.cols; ++x)
        {
            // the bigger the alpha value, the less of the original image is kept at that pixel
            cv::Vec4b imgPix = outputWeightSum.at<cv::Vec4b>(y,x);
            cv::Vec4b gridPix = gridAlpha.at<cv::Vec4b>(y,x);

            // use alpha channel vor blending
            float blendpart = (float)gridPix[3]/(float)255;

            // set pixel value to blended value
            outputWeightSum.at<cv::Vec4b>(y,x) = blendpart * gridPix + (1.0f-blendpart) * imgPix;
        }