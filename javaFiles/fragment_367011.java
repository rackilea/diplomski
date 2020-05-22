generatePdf() {

this.yourService.generatePdf()
     .subscribe(pdf => {
     let mediaType = 'application/pdf';
     let blob = new 
     Blob([this.converterService.base64ToArrayBuffer(pdf.pdfByteArray)], { type: mediaType });
    saveAs(blob, fileName);
  }, err => {
    console.log('Pdf generated err: ', JSON.stringify(err));
  });