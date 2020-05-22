import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import com.sap.aii.mapping.api.AbstractTrace;
import com.sap.aii.mapping.api.StreamTransformation;
import com.sap.aii.mapping.api.StreamTransformationConstants;
import com.sap.aii.mapping.api.StreamTransformationException;
import com.sap.aii.mapping.value.api.IFIdentifier;
import com.sap.aii.mapping.value.api.IFRequest;
import com.sap.aii.mapping.value.api.IFResponse;
import com.sap.aii.mapping.value.api.XIVMFactory;
import com.sap.aii.mapping.value.api.XIVMService;

public class PGPEncryptor implements StreamTransformation {
    private Map param;
    private AbstractTrace trace;
    private String receiver = null;
    private static final String SOURCE_AGENCY = "YOUR_SOURCE_AGENCY";
    private static final String SOURCE_SCHEME = "YourKeyPath";
    private static final String TARGET_AGENCY = "YOUR_TARGET_AGENCY";
    private static final String TARGET_SCHEME = "YourKeyPath";

    public void setParameter(Map arg0) {
        param = arg0;
        trace = (AbstractTrace) param.get(StreamTransformationConstants.MAPPING_TRACE);
        receiver = (String) param.get(StreamTransformationConstants.RECEIVER_SERVICE);
    }

    public void execute(InputStream in, OutputStream out) throws StreamTransformationException {
        try {
            IFIdentifier sourceIdentifier = XIVMFactory.newIdentifier(SOURCE_AGENCY, SOURCE_SCHEME);
            IFIdentifier targetIdentifier = XIVMFactory.newIdentifier(TARGET_AGENCY, TARGET_SCHEME);
            IFRequest request = XIVMFactory.newRequest(sourceIdentifier, targetIdentifier, receiver);
            trace.addInfo("Value Mapping lookup value: " + receiver);
            IFResponse response = XIVMService.executeMapping(request);
            String encKey;
            if (response.hasTargetValues()) {
                encKey = response.getSingleTargetValue();
                trace.addInfo("Using key path: " + encKey);
            } else {
                trace.addInfo("Value Mapping lookup parameters");
                trace.addInfo("Source");
                trace.addInfo("Context: " + sourceIdentifier.getContext() + ", Agency: " + SOURCE_AGENCY + ", Scheme: "
                        + SOURCE_SCHEME);
                trace.addInfo("Target");
                trace.addInfo("Context: " + targetIdentifier.getContext() + ", Agency: " + TARGET_AGENCY + ", Scheme: "
                        + TARGET_SCHEME);
                trace.addInfo("Value: " + receiver);
                throw new StreamTransformationException("Public key not found.");
            }

            // Encrypt the message
            long start = System.currentTimeMillis();
            trace.addInfo("Encryption started");
            new PGPCrypto().encrypt(encKey, in, out, trace);
            trace.addInfo("Encryption ended successfully in " + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            trace.addInfo(e.getMessage());
        }
    }
}