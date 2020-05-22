formData = new FormData();
this.formData.append('file', blob);

postMyBlob(formData: any) {
    return this.http.post(`${AppUtils.REST_API_SERVER}/upload-file`, formData);
  }