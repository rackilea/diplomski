downloadFile(documentPath) {
    this.msgService.downloadFile(documentPath).subscribe(response => {
        let params = documentPath.split('/' );
        var blob = new Blob([response._body]);
        FileSaver.saveAs(blob, params[params.length-1]);
      });
  }