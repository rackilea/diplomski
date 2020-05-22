//-------------------------Example Strings---------------------------------------------
  private static String oldText = "I yoyo am also working on a \n webapp in which the user can make changes to a text area. " +
      "In this, he can either write one paragraph, one sentence." +
      " So what I am currently trying to do is to split the whole paragraph by a dot separator. " +
      "Once that is done, I would like to check which sentences have changed." +
      " I am currently doing it using for loop, which is not accurate as I have to length of array to Math.minimum of both String arrays." +
      " But it is not working, I am getting zero String modified from it."+
      " Kindly let me know what I am doing wrong.";

  private static String newText = "akshay is also working on a \n webapp in which the user can make changes to a text area. " +
      "He can either write one paragraph, one sentence." +
      " So what I am currently trying to do is to split the whole paragraph by a dot separator. " +
      "Once that is done, I would like to check which sentences have changed." +
      " I am currently doing it using for loop, which is not accurate as I have to length of array to Math.minimum of both String arrays." +
      " But it is not working, I am getting zero String modified from it.";
  //-------------------------Example Strings end --------------------------------------

  private static diff_match_patch diffMatchPatch;

  public static void main(String[] args) {

    diffMatchPatch = new diff_match_patch();
    //Split text into List of strings
    List<String> oldTextList = Arrays.asList(oldText.split("(\\.|\\n)"));
    List<String> newTextList = Arrays.asList(newText.split("(\\.|\\n)"));

    //If we have different length
    int counter = Math.max(oldTextList.size(), newTextList.size()); 
    StringBuilder sb = new StringBuilder();

    for(int current = 0; current < counter; current++){
      String oldString = null;
      String newString = null;

      if(oldTextList.size() <= current){
        oldString = "";
        newString = newTextList.get(current);

      } else if (newTextList.size() <= current){
        oldString = oldTextList.get(current);
        newString = "";
      } else {
        if (isLineDifferent(oldTextList.get(current), newTextList.get(current))){
          oldString = oldTextList.get(current);
          newString = newTextList.get(current);
        }
      }
      if(oldString != null && newString != null) {
        //---- Insert into database here -----
        sb.append("Changes for Line: " + current + "\n");
        sb.append("Old: " + oldString + "; New: " + newString +";\n");
      }
    }

    System.out.println(sb.toString());
  }

  private static boolean isLineDifferent(String oldString, String newString) {
    LinkedList<diff_match_patch.Diff> deltas = diffMatchPatch.diff_main(oldString,newString);
    for(diff_match_patch.Diff d : deltas){
      if (d.operation == diff_match_patch.Operation.EQUAL) continue;
      return true;
      }
    return false;
    }
  }