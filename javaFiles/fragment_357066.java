if (in == null) 
     return null;

DTOIntIdentityDocument out = new DTOIntIdentityDocument();
out.setDocumentType(this.mapDocumentTypeÇ(in.getDocumenttype()));
out.setDocumentNumber(in.getDocumentnumber());
return out;