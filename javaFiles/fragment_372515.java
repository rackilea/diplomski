flandmark_detect(input, bbox, model, landmarks);

// display landmarks
cvRectangle(orig, cvPoint(bbox[0], bbox[1]), cvPoint(bbox[2], bbox[3]), CV_RGB(255, 0, 0));
cvRectangle(orig,
cvPoint((int) model.bb().get(0), (int) model.bb().get(1)),
cvPoint((int) model.bb().get(2), (int) model.bb().get(3)), CV_RGB(0, 0, 255));
cvCircle(orig,
cvPoint((int) landmarks[0], (int) landmarks[1]), 3, CV_RGB(0, 0, 255), CV_FILLED, 8, 0);
for (int i = 2; i < 2 * model.data().options().M(); i += 2) {
    cvCircle(orig, cvPoint((int) (landmarks[i]), (int) (landmarks[i + 1])), 3, CV_RGB(255, 0, 0), CV_FILLED, 8, 0);
}