realm.executeTransactionAsync(new Realm.Transaction() {
                                          @Override
                                          public void execute(Realm bgRealm) {

                                              final ModelClass modelClass = bgRealm.createObject(ModelClass.class);
                                              try {
                                                  InputStream file = getAssets().open("goodie.txt");
                                                  reader = new BufferedReader(new InputStreamReader(file));
                                                  final String[] line = {reader.readLine()};
                                                  while (line[0] != null) {
                                                              try {
                                                                  line[0] = reader.readLine();
                                                              } catch (IOException e) {
                                                                  e.printStackTrace();
                                                              }
                                                              String[] namelist = line[0].split(":");
                                                              String iWord = namelist[0];
                                                              String iDesc = namelist[1];
                                                              modelClass.setName(iWord);
                                                              modelClass.setDesc(iDesc);
                                                              count++;

                                                  }
                                              } catch (IOException e) {
                                                  e.printStackTrace();
                                              } finally {
                                                  if (realm != null)
                                                      realm.close();
                                              }
                                          }

                                      }, new Realm.Transaction.OnSuccess() {
                                          @Override
                                          public void onSuccess() {
                                              Toast.makeText(MainActivity.this, "Added " + count + "items", Toast.LENGTH_SHORT).show();
                                          }
                                      }, new Realm.Transaction.OnError() {

                                          @Override
                                          public void onError(Throwable error) {


                                          }
                                      }
        );
    } catch (Exception e) {
        e.printStackTrace();
    }