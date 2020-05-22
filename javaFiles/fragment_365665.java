class SomeImplementation extends YourInterface {
   def sendDocumentToUser(document: Document, user: User) = {
     this.sendDocumentToUser(document.getId, user.getId)
   }
   // ....
}