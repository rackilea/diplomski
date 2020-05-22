onUpload(event) {
    var fd = new FormData();
    for (let file of event.files) {
      fd.append('file', file);
    }
    // POST the data to the backend
    this.http.post(url, fd);
  }