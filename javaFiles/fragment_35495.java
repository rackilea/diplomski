saveHeaders(mapHeaders:HeaderMappingDetails){
    let url = this.serverPath+'/user/saveHeaders';
    const headers: HttpHeaders = new HttpHeaders();
    headers.set("content-type", "application/json");
    headers.set("x-auth-token", localStorage.getItem('xAuthToken'));
    const options = {
      headers: headers
    };
    console.dir(mapHeaders);
    return this.http.post(url, mapHeaders, options);
}