URL url;
Checks checks; // <-- url is null.
public Api(URL url){
    this.url = new URL(url+"/api");
    checks = new Checks(this.url); // <-- now url is initialized.
}