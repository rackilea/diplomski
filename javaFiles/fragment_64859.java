String json = response.body().toString();
Gson mGson = new Gson();

//where Example is the root of JSON
Example rsp = mGson.fromJson(json, Example.class);

//Entry is the list I needed to access
List <Entry> listOfEntrys= rsp.getFeed().getEntry();

//get value
Log.i("MainActivity", "listaEntrya " + listOfEntrys.get(0).getTitle().get$t());