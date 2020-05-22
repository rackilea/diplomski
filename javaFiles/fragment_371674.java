// flag to see if any matches are found
boolean foundSomething = false;

for (int i = 0; i < namesArray.length; i++) {
     String theName = namesArray[i].getName();
     if (theName.toUpperCase().contains(targetSubstring))
     {
         displayArea.append("\n"  + namesArray[i].getName() + "\t" + namesArray[i].bestDecade());
         foundSomething = true;
     }
}

// Now, if you didn't find anything, then add this
if (!foundSomething) { 
      displayArea.append("\n No results found");
}