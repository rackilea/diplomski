PDSignatureField signatureField = FIND_YOUR_SIGNATURE_FIELD_TO_SIGN;
PDSignature signature = new PDSignature();
signatureField.setValue(signature);

COSBase lock = signatureField.getCOSObject().getDictionaryObject(COSName.getPDFName("Lock"));
if (lock instanceof COSDictionary)
{
    COSDictionary lockDict = (COSDictionary) lock;
    COSDictionary transformParams = new COSDictionary(lockDict);
    transformParams.setItem(COSName.TYPE, COSName.getPDFName("TransformParams"));
    transformParams.setItem(COSName.V, COSName.getPDFName("1.2"));
    transformParams.setDirect(true);
    COSDictionary sigRef = new COSDictionary();
    sigRef.setItem(COSName.TYPE, COSName.getPDFName("SigRef"));
    sigRef.setItem(COSName.getPDFName("TransformParams"), transformParams);
    sigRef.setItem(COSName.getPDFName("TransformMethod"), COSName.getPDFName("FieldMDP"));
    sigRef.setItem(COSName.getPDFName("Data"), document.getDocumentCatalog());
    sigRef.setDirect(true);
    COSArray referenceArray = new COSArray();
    referenceArray.add(sigRef);
    signature.getCOSObject().setItem(COSName.getPDFName("Reference"), referenceArray);
}

signature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);
signature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED);
signature.setName("blablabla");
signature.setLocation("blablabla");
signature.setReason("blablabla");
signature.setSignDate(Calendar.getInstance());
document.addSignature(signature [, ...]);