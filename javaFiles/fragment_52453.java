package org.geotools.tutorial;

import java.awt.geom.Point2D;
import java.io.File;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.factory.Hints;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.opengis.referencing.crs.CRSAuthorityFactory;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.geotools.referencing.*;
/**
 * Prompts the user for a shapefile and displays the contents on the screen in a map frame.
 * <p>
 * This is the GeoTools Quickstart application used in documentationa and tutorials. *
 */
public class quickstart {

/**
 * GeoTools Quickstart demo application. Prompts the user for a shapefile and displays its
 * contents on the screen in a map frame
 */
    public static void main(String[] args) throws Exception {
        //Point2D.Double srcProjec = new Point2D.Double (836694.050, 819069.800);
        //Point2D.Double dstProjec = new Point2D.Double (132,37);
        // display a data store file chooser dialog for shapefiles
        //Hints hints = new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE);
        //CRSAuthorityFactory factory = ReferencingFactoryFinder.getCRSAuthorityFactory("EPSG", hints);
        //CoordinateReferenceSystem crs = factory.createCoordinateReferenceSystem("EPSG:4326");
        CRSAuthorityFactory   factory = CRS.getAuthorityFactory(true);
        CoordinateReferenceSystem srcCRS = factory.createCoordinateReferenceSystem("EPSG:2326");
        CoordinateReferenceSystem dstCRS = factory.createCoordinateReferenceSystem("EPSG:4326");
        boolean lenient = true; // allow for some error due to different datums
        MathTransform transform = CRS.findMathTransform(srcCRS, dstCRS, lenient);
        double[] srcProjec = {818039, 836361};// easting, northing, 
        double[] dstProjec = {0, 0};
        transform.transform(srcProjec, 0, dstProjec, 0, 1);
        System.out.println("longitude: " + dstProjec[0] + ", latitude: " + dstProjec[1]);

    }

}