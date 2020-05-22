public void FunctionExample(ArrayList contacts) {

  for(int i=0; i < contacts.size(); i++) {

        LinkedTreeMap<String, Object> map = (LinkedTreeMap<String, Object>) contacts.get(i);
        map.containsKey("id");
        String id = (String) map.get("id");
        map.containsKey("contact_name");
        String contact_name = (String) map.get("contact_name");
        map.containsKey("numbers");
        String numbers = (String) map.get("numbers");
        numbers.replace("{","").replace("}","");
        map.containsKey("emails");
        String emails = (String) map.get("emails");
        emails.replace("{","").replace("}","");

        Snackbar.make(getView(), id, Snackbar.LENGTH_LONG).show();
        Snackbar.make(getView(), contact_name, Snackbar.LENGTH_LONG).show();
        Snackbar.make(getView(), numbers, Snackbar.LENGTH_LONG).show();
        Snackbar.make(getView(), emails, Snackbar.LENGTH_LONG).show(); 

  }
}