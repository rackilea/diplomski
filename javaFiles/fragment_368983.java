...
 job.setPageable(doc);
 job.setPrintService(myPrintService);
 PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet(); 
 PageRanges pageRng = new PageRanges( lower , upper);
 attr.add(pageRng); 
 job.print(attr);