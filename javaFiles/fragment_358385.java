prepareData() {


console.log("this.FilterData"+JSON.stringify(this.FilterData)); 
  this.loading = true;
   this.SharedHttpClientService.post(
    this.UrlsService.setAPIURl(
      APIURL.Surveillance_OatsException_Summary),
      this.FilterData)
    .map((response: Response) => {
      this.isLoadingResults = false;
      this.isRateLimitReached = false;
      return response.json();
    })
    .subscribe(Element => {
      this.dataset=Element;
    },
      (err: HttpErrorResponse) => {
        this.isLoadingResults = false;
        this.isRateLimitReached = true;
    });
    this.loading = false;


}