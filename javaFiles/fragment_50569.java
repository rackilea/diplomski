private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {       
    final SayingsHolder holder = (SayingsHolder).getApplication(); //This line a member declaration. And a valid sysntax. So no issues here

    holder.getSayingsList(); // This is a statement. So this line creates issue as its not part of a class body. 
                // Statements should be enclosed within a method body or static block or for an assigment.

    //But instead if you say it like
    List<String> sayingsList = holder.getSayingsList(); // Now it became a filed(member) declaration. You are trying to declare a member names "sayingsList" just like you created "holder" above
    //So now we converted the statement to a member declaration
}