public void onCreate()
{
    //Create all your fragments here eg F1 f1 = new F1(); etc

    //For whatever fragment you have created you should call the method addFragment

    //Now depending on what fragment you want shown by default you should call attachFragment or detachFragment. eg. if F1 has to be shown by default
    attachFragment(F1);
    detachFragment(F2) //and all otherfragment you want hidden by default

    //Set the listeners for the buttons

    //The purpose of the next two lines is to store the current state of the buttons. Since F1 is attached to button1 and it is currently being shown we set the tag to "clicked"
    //and button2 tag has been set to notClicked
    button1.setTag("clicked");
    button2.setTag("notClicked");
}