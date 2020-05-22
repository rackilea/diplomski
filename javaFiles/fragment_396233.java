@Inject
EPartService partService;


MPart mpart = partService.findPart("part id");

BibliotekaZmianyPart part = (BibliotekaZmianyPart)mpart.getObject();

part.editBook();   // Using non-static 'editBook'