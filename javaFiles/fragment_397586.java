({
  downloadPdf: function() {
    return $http({
      method: 'GET',
      url: this.baseUrl + "/downloadpdf",
      responseType: "blob"
    });
  }
});