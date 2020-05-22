final String[] dlUrl = new String[]{"www.google.com/document.pdf",
                                    "www.google.com/document2.pdf",
                                    "www.google.com/document3.pdf"}; // { removed

for(int k = 0; k < dlUrl.length; k++) { 
               ^

    final String currentUrl = dlUrl[k];
                              ^^^^^^^^

    downloadFile.execute(currentUrl); 
}