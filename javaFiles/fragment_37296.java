Transformer identityTransform = TransformerFactory.newInstance().newTransformer();
DOMResult domResult = new DOMResult();
identityTransform.transform(soapBody.getPayloadSource(), domResult);

Node bodyContent = domResult.getNode(); // modify this

identityTransform.transform(new DOMSource(bodyContent), soapBody.getPayloadResult());