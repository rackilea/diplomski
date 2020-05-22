//code within the above while()
    PdfDictionary d = entry.getValue().getMerged(0);
    PdfString fieldDA = d.getAsString(PdfName.DA);

    //in case of no form field default appearance create a default one
    if(fieldDA==null) ...

    Object[] infos = AcroFields.splitDAelements(fieldDA.toString());
    if(infos[0]!=null) String fontName = (String)infos[0];
    if(infos[1]!=null) float fontSize= (((Float)infos[1]).floatValue());