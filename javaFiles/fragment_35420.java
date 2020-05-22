@Test
public void myTest() {
  DocuSigRESTProvider docusignRestProvider = new DocuSigRESTProvider();
  docusignRestProvider.setTransformer(new SendDocumentsRESTTransformerStub());

  //...rest of test code.
}

private class SendDocumentsRESTTransformerStub extends SendDocumentsRESTTransformer {
  //... Override methods.
}