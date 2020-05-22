package de.mhaller.bouncycastle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.util.Collection;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerId;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.tsp.TimeStampTokenInfo;

public class VerifyTimestampSignature {

    private static boolean found;

    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 1) {
            System.out.println("usage: java " + VerifyTimestampSignature.class.getName()
                    + " [jar-file|dsa-file]");
            return;
        }

        BouncyCastleProvider provider = new BouncyCastleProvider();
        Security.addProvider(provider);

        String filename = args[0];

        if (filename.toLowerCase().endsWith(".dsa")) {
            InputStream dsa = new FileInputStream(filename);
            printDSAInfos(filename, dsa);
            return;
        }

        if (filename.toLowerCase().endsWith(".jar")) {
            InputStream jar = new FileInputStream(filename);
            JarInputStream jarInputStream = new JarInputStream(jar);
            JarEntry nextJarEntry;
            do {
                nextJarEntry = jarInputStream.getNextJarEntry();
                if (nextJarEntry == null) {
                    break;
                }
                if (nextJarEntry.getName().toLowerCase().endsWith(".dsa")) {
                    printDSAInfos(nextJarEntry.getName(), jarInputStream);
                }
            } while (nextJarEntry != null);
        }

        if (!found) {
            System.out.println("No certificate with time stamp information found in " + filename);
        } else {
            System.out.println("Found at least one time stamp info");
            System.out.println("Note: But it was NOT verified for validity!");
        }
    }

    private static void printDSAInfos(String file, InputStream dsa) throws CMSException,
            IOException, TSPException {
        System.out.println("Retrieving time stamp token from: " + file);
        CMSSignedData signature = new CMSSignedData(dsa);
        SignerInformationStore store = signature.getSignerInfos();
        Collection<?> signers = store.getSigners();
        for (Object object : signers) {
            SignerInformation signerInform = (SignerInformation) object;
            AttributeTable attrs = signerInform.getUnsignedAttributes();
            if (attrs == null) {
                System.err
                        .println("Signer Information does not contain any unsigned attributes. A signed jar file with Timestamp information should contain unsigned attributes.");
                continue;
            }
            Attribute attribute = attrs.get(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken);
            DEREncodable dob = attribute.getAttrValues().getObjectAt(0);
            CMSSignedData signedData = new CMSSignedData(dob.getDERObject().getEncoded());
            TimeStampToken tst = new TimeStampToken(signedData);

            SignerId signerId = tst.getSID();
            System.out.println("Signer: " + signerId.toString());

            TimeStampTokenInfo tstInfo = tst.getTimeStampInfo();
            System.out.println("Timestamp generated: " + tstInfo.getGenTime());
            found = true;
        }
    }
}