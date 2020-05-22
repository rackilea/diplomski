package org.name.company;

import hex.glm.GLMModel;
import water.H2O;
import water.Key;
import water.api.StreamWriter;
import water.api.StreamingSchema;
import water.fvec.Frame;
import water.fvec.NFSFileVec;
import hex.glm.GLMModel.GLMParameters.Family;
import hex.glm.GLMModel.GLMParameters;
import hex.glm.GLM;
import water.util.JCodeGen;

import java.io.*;
import java.util.Map;

public class Launcher
{
    public static void initCloud(){
        String[] args = new String [] {"-name", "h2o_test_cloud"};
        H2O.main(args);
        H2O.waitForCloudSize(1, 10 * 1000);
    }

    public static void main( String[] args ) throws Exception {
        // Initialize the cloud
        initCloud();

        // Create a Frame object from CSV
        File f = new File("/path/to/data.csv");
        NFSFileVec nfs = NFSFileVec.make(f);
        Key frameKey = Key.make("frameKey");
        Frame fr = water.parser.ParseDataset.parse(frameKey, nfs._key);

        // Create a GLM and output coefficients
        Key modelKey = Key.make("modelKey");
        try {
            GLMParameters params = new GLMParameters();
            params._train = frameKey;
            params._response_column = fr.names()[1];
            params._intercept = true;
            params._lambda = new double[]{0};
            params._family = Family.gaussian;

            GLMModel model = new GLM(params).trainModel().get();
            Map<String, Double> coefs = model.coefficients();
            for(Map.Entry<String, Double> entry : coefs.entrySet()) {
                System.out.format("%s: %f\n", entry.getKey(), entry.getValue());
            }

            String filename = JCodeGen.toJavaId(model._key.toString()) + ".java";
            StreamingSchema ss = new StreamingSchema(model.new JavaModelStreamWriter(false), filename);
            StreamWriter sw = ss.getStreamWriter();
            OutputStream os = new FileOutputStream("/base/path/" + filename);
            sw.writeTo(os);

        } finally {
            if (fr != null) {
                fr.remove();
            }
        }
    }
}