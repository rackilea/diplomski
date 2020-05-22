class DocuSigRESTProvider{
 private ITransformer transformer = new SendDocumentsRESTTransformer();

 public IDocumentSet sendDocuments() {
   /// code...
   ITransformerResult result = transformer.transformRequest(args);
 }
  //package level method
 void setTransformer(ITransformer transformer) {
    this.transformer = transformer
 }
}