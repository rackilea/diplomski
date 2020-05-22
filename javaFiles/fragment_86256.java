import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;

...
  for (XWPFParagraph paragraph : paragraphs) {
   List<CTHyperlink> hyperlinks = paragraph.getCTP().getHyperlinkList();
   CTHyperlink[] hyperlinksarr = hyperlinks.toArray(new CTHyperlink[0]);
   for (int i = 0; i < hyperlinksarr.length; i++ ) {
    CTHyperlink hyperlink = hyperlinksarr[i];
System.out.println(hyperlink.getRArray(0).getTArray(0).getStringValue());
    paragraph.getCTP().removeHyperlink(0);
   }
  }
...