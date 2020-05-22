void rotateMatCW(const cv::Mat& src, cv::Mat& dst, const double& deg )
    if (deg == 270 || deg == -90){
        // Rotate clockwise 270 degrees
        cv::transpose(src, dst);
        cv::flip(dst, dst, 0);
    }
    else if (deg == 180 || deg == -180){
        // Rotate clockwise 180 degrees
        cv::flip(src, dst, -1);
    }
    else if (deg == 90 || deg == -270){
        // Rotate clockwise 90 degrees
        cv::transpose(src, dst);
        cv::flip(dst, dst, 1);
    }
    else if (deg == 360 || deg == 0 || deg == -360){
        if (src.data != dst.data){
            src.copyTo(dst);
        }
    }
    else
    {
        cv::Point2f src_center(src.cols / 2.0F, src.rows / 2.0F);
        cv::Mat rot_mat = getRotationMatrix2D(src_center, 360 - deg, 1.0);
        warpAffine(src, dst, rot_mat, src.size());
    }
}