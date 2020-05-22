PDPage page = document.getPage(1);

PDAnnotationLink link         = new PDAnnotationLink();
PDPageDestination destination = new PDPageFitWidthDestination();
PDActionGoTo action           = new PDActionGoTo();

destination.setPage(document.getPage(2));
action.setDestination(destination);
link.setAction(action);
link.setPage(page);

link.setRectangle(page.getMediaBox());
page.getAnnotations().add(link);