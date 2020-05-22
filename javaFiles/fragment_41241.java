//Search by name and type folder
String qStr = "mimeType = 'application/vnd.google-apps.folder' and title = 'myFolder'";

//Get the list of Folders
FileList fList=service.files().list().setQ(qStr).execute();

//Check that the result is one folder
File folder;

if (fList.getItems().lenght==0){
    folder=fList.getItems()[0];

}