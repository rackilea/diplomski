@PostConstruct
protected void onCreate() {
  if(this.createdOn == null) {
     this.createdOn = new Date();
  }
}