let formData:FormData = new FormData();
    formData.append('file', file, file.name);
    let headers = new Headers();
    headers.append('Content-Type', 'multipart/form-data')
    headers.append('Accept', 'application/json');
let options = new RequestOptions({ headers: headers });
    this.http.post(URL_API_REST + 'upload', formData, options)