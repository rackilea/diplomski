Mat scoresData = scores.row(y);
Mat x0Data = geometry.submat(0, height, 0, width).row(y);
Mat x1Data = geometry.submat(height, 2 * height, 0, width).row(y);
Mat x2Data = geometry.submat(2 * height, 3 * height, 0, width).row(y);
Mat x3Data = geometry.submat(3 * height, 4 * height, 0, width).row(y);
Mat anglesData = geometry.submat(4 * height, 5 * height, 0, width).row(y);