public void updateToast(Date date, ArrayList<HashMap<String, String>> contactList) {
    String formattedDate = formatter.format(date);
    for (int i = 0; i < contactList.size(); i++)
    {
        if (formattedDate.equals(contactList.get(i).get(TAG_DATED))) 
        {
           if(contactList.get(i).get(TAG_STATUS).equals("Occupied"))
           {
              Toast.makeText(getApplicationContext(),"S",Toast.LENGTH_SHORT).show();
              return;
           } else if(contactList.get(i).get(TAG_STATUS).equals("Reserved")) 
           {
              Toast.makeText(getApplicationContext(),"R",Toast.LENGTH_SHORT).show();
              return;
           }
        }
    }
    // If here then its not found in any lists throw up your other text.
    Toast.makeText(getApplicationContext(),"NP",Toast.LENGTH_SHORT).show();
}