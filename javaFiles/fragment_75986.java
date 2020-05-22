RichTextItem body = doc.getFirstItem("Attachements");
Vector v = body.getEmbeddedObjects();
Enumeration e = v.elements();
while (e.hasMoreElements()) {
   EmbeddedObject eo = (EmbeddedObject)e.nextElement();

   if (eo.getType() == EmbeddedObject.EMBED_ATTACHMENT) {
         System.out.println("\t" + eo.getName());
         eo.extractFile("c:\\extracts\\" + eo.getSource());
         eo.remove();
   }
}