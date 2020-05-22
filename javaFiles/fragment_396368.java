CloudApp.init("*****", "*****")
CloudObject obj = new CloudObject("User", "1uvSDThQ");
Log.e("LOG", "1"); 
try {
    obj.set("color", "#000000");
    obj.setAcl(new ACL());
    obj.save(new CloudObjectCallback() {
        @Override