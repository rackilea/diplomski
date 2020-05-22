public Example(UIController controller) {
    this.controller = controller;
}

@Override
void onPreExecute() {
    //PREPARE GUI, SHOW PROGRESS OR SOMETHING....
    this.controller.updateProgressLabel("Starting Download")
}

@Override
String doInBackground() {
    //THIS METHOD WORKING IN BACKGROUND HERE YOU SOULD IMPLEMENT CODE OF HTTP REQUEST AND RETURN RESULT OF REQUEST FOR EXAMPLE OBJECT OR JSON STRING
  return new String();
}

@Override
void onPostExecute(String result) {
    //HERE YOU CAN GET YOUR DATA FROM REQUEST AND SET RESULT ON GUI
    this.controller.updateProgressLabel("result);
}

@Override
void progressCallback(Object... params) {

}