import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Segmentation {

    private Region[] regions = null;
    private Mat labeled = null;

    public Segmentation(Mat image, int bwThreshold) {

        Mat gray = new Mat(image.size(), CvType.CV_8U);

        if (image.type() != CvType.CV_8U) {
            Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);
        } else {
            image.copyTo(gray);
        }

        Mat bw = Mat.zeros(image.size(), image.type());
        Imgproc.threshold(gray, bw, bwThreshold, 255, Imgproc.THRESH_BINARY_INV);

        createRegions(bw);

        // Free memory
        kernel.release();
        gray.release();
        bw.release();
    }

    public Segmentation(Mat image) {
        this(image, 210);
    }

    private void createRegions(Mat image) {
        labeled = new Mat(image.size(), image.type());

        // Extract components
        Mat rectComponents = Mat.zeros(new Size(0, 0), 0);
        Mat centComponents = Mat.zeros(new Size(0, 0), 0);
        Imgproc.connectedComponentsWithStats(image, labeled, rectComponents, centComponents);

        // Collect regions info
        int[] rectangleInfo = new int[5];
        double[] centroidInfo = new double[2];
        regions = new Region[rectComponents.rows() - 1];

        for(int i = 1; i < rectComponents.rows(); i++) {

            // Extract bounding box
            rectComponents.row(i).get(0, 0, rectangleInfo);
            Rect rectangle = new Rect(rectangleInfo[0], rectangleInfo[1], rectangleInfo[2], rectangleInfo[3]);

            // Extract centroids
            centComponents.row(i).get(0, 0, centroidInfo);
            Point centroid = new Point(centroidInfo[0], centroidInfo[1]);

            regions[i - 1] = new Region(rectangle, centroid);
        }

        // Free memory
        rectComponents.release();
        centComponents.release();
    }

    /**
    * Extract region mask from labeled Mat
    *
    * @param region
    * @return Mat
    */
    public Mat getRegionMask(Region region) {
        int i = Arrays.asList(regions).indexOf(region);
        Mat mask = new Mat(labeled.size(), labeled.type());
        Scalar color = new Scalar(i + 1, i + 1, i + 1);
        Core.inRange(labeled, color, color, mask);
        return mask;
    }

    public Region[] getRegions() {
        return regions;
    }

    public Region getRegion(int index) {
        return regions[index];
    }

    /**
     * Call this method to release private Mat member
     */
    public void release() {
        labeled.release();
    }

    /**
    * Extract original image of the region using the region mask
    * @param image Original image
    * 
    */
    public Mat getRegionImageWithMask(Mat image, Region region) {
        Mat mask = getMask(region);
        Mat result = Mat.zeros(image.size(), image.type());
        result.setTo(new Scalar(255,255,255));
        image.copyTo(result, mask);
        Mat boxImage = new Mat(result, region.getBounding());
        mask.release();
        result.release();
        return boxImage;
    }

    /**
    * Extract original image of the region using the region mask
    * @param image Original image
    * 
    */
    public Mat getRegionImage(Mat image, Region region) {
        return new Mat(image, region.getBounding());;
    }

    public class Region {
        private Rect bounding;
        private Point centroid;

        public Region(Rect bounding, Point centroid) {
            this.bounding = bounding;
            this.centroid = centroid;
        }

        public Rect getBounding() {
            return bounding;
        }

        public Point getCentroid() {
            return centroid;
        }
    }
}