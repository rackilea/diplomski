importIt(id: number, myFile: File) {
    const dataUrl = 'the/path/import/' + id;

    const formData = new FormData();
    formData.append('file', myFile);

    let options = new RequestOptions({
       method: RequestMethod.Post
     });

    return this.http.post(dataUrl, formData, options)
      .map(res => res)
      .catch(this.handleError.bind(this));
}