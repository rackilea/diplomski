// Removing the field references relating the widget...
    PdfDictionary fieldPartDictionary = widget.getBaseDataObject();
    while (fieldPartDictionary != null)
    {
      [...]
      kidsArray.remove(fieldPartDictionary.getReference());
      [...]
    }