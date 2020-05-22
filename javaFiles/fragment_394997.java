if(ptg instanceof Ref3DPxg){
   Ref3DPxg pxg = (Ref3DPxg)ptg;
   int extWB = pxg.getExternalWorkbookNumber();
   int extLink = extWB-1;
   ExternalLinksTable links = wb.getExternalLinksTable().get(extLink);
   String filename = links.getLinkedFileName();
}