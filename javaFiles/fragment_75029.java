try {

            ArrayList<CategoryList>categoryList = new ArrayList<CategoryList>();
            JSONObject jsonObject = new JSONObject("yourResopnseVariable");

            JSONArray categoryArray = jsonObject.getJSONArray("Category");

            for (int i = 0; i < categoryArray.length(); i++)
            {
                JSONObject job = categoryArray.getJSONObject(i);

                int categoryId = job.getInt("Category_id");
                String categoryName = job.getString("Category_name");

                //this is for email array
                ArrayList<String> emails = new ArrayList<>();
                JSONArray emailArray = job.getJSONArray("Emails");
                for (int j = 0; i < emailArray.length(); j++){
                    JSONObject jobE = emailArray.getJSONObject(j);
                    emails.add(jobE.getString(""+j));
                }

                //This i for Epabx array
                ArrayList<String> epabx = new ArrayList<>();
                JSONArray epabxArray = job.getJSONArray("Epabx");
                for (int j = 0; i < epabxArray.length(); j++){
                    JSONObject jobE = epabxArray.getJSONObject(j);
                    epabx.add(jobE.getString(""+j));
                }

                //This i for Category_Fax array
                ArrayList<String> category_Fax = new ArrayList<>();
                JSONArray category_FaxJson = job.getJSONArray("Category_Fax");
                for (int j = 0; i < category_FaxJson.length(); j++){
                    JSONObject jobE = category_FaxJson.getJSONObject(j);
                    category_Fax.add(jobE.getString(""+j));
                }

                //This i for Persons array
                ArrayList<Persons> personsList = new ArrayList<>();
                JSONArray personsArray = job.getJSONArray("Persons");
                for (int j = 0; i < personsArray.length(); j++){
                    JSONObject jobIn = personsArray.getJSONObject(j);

                    int Person_ID = jobIn.getInt("Person_ID");
                    String Name = jobIn.getString("Name");
                    String Designation = jobIn.getString("Designation");
                    String Office_Phone = jobIn.getString("Office_Phone");
                    String Residence_Phone = jobIn.getString("Residence_Phone");
                    String VOIP = jobIn.getString("VOIP");
                    String Address = jobIn.getString("Address");

                    //this is for Fax array
                    ArrayList<String>Fax = new ArrayList<>();
                    JSONArray fax = jobIn.getJSONArray("Fax");
                    for (int k=0; k < fax.length(); k++)
                    {
                        JSONObject jobI = fax.getJSONObject(k);
                        Fax.add(jobI.getString(""+k));
                    }
                    String Ext = jobIn.getString("Ext");

                    personsList.add(new Persons(Person_ID, Name, Designation, Office_Phone, Residence_Phone,
                            VOIP, Address, Fax, Ext));
                }

                //here your Category[] value store in categoryArrayList
                categoryList.add(new CategoryList(categoryId, categoryName, emailArray, epabx, category_Fax, personsList));
            }

            if (categoryList != null)
            {
                Log.i("categoryList size = ", ""+categoryArray.length());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }