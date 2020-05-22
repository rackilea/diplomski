downloadFile(path) {
    const headers = new Headers({'Content-Type': 'text/plain', 'Accept': '*'});
    const options = new RequestOptions({headers: headers});
    options.responseType = ResponseContentType.Blob;
    return this.http.get(apiUrl + "msg/download/"+btoa(path), options)
      .map(res => res)
      .catch(this.handleError);
  }