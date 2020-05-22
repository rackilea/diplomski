//Inside the onNavigationItemSelected
String value = "";
if(currentFragment instanceof MyCustomFragment1){
    value = ((MyCustomFragment1)currentFragment).methodForGettingTextViewValue();
}else if(currentFragment instanceof MyCustomFragment2){
    //This one has the edittext
    value = ((MyCustomFragment2)currentFragment).methodForGettingEditTextValue();
}
//Then create the intent
//Intent shareIntent ...