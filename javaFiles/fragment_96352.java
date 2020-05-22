public class HtmlTagHandler implements Html.TagHandler {
    private int mListItemCount = 0;
    private Vector<String> mListParents = new Vector<String>();
    private Vector<Integer> mListCounter = new Vector<Integer>();


    @Override
    public void handleTag(final boolean opening, final String tag, Editable output, final XMLReader xmlReader) {

        if (tag.equals("ul") || tag.equals("ol") ) {
            if (opening) {
                mListParents.add(mListParents.size(),tag);
                mListCounter.add(mListCounter.size(),  0);

            } else {
                Log.d("Bohhh"," tolgo "+mListParents.get(mListParents.size()-1));
                mListParents.removeElementAt(mListParents.size()-1);
                Log.d("Bohhh","lunghezza "+mListParents.size());
                mListCounter.removeElementAt(mListCounter.size()-1);

            }

        } else if (tag.equals("li") && opening) {
            handleListTag(output);
        }



    }



    private void handleListTag(Editable output) {

        if (mListParents.lastElement().equals("ul")) {
           if(output.length()!=0)
            output.append("\n");
            for(int i=1;i<mListCounter.size();i++)
                output.append("\t");
            output.append("• ");
           } else if (mListParents.lastElement().equals("ol")) {
            mListItemCount=            mListCounter.lastElement()+1;
            if(output.length()!=0)
            output.append("\n");
            for(int i=1;i<mListCounter.size();i++)
                output.append("\t");
           output.append( mListItemCount + ". ");
           mListCounter.removeElementAt(mListCounter.size()-1);
           mListCounter.add(mListCounter.size(), mListItemCount);
      }
    }

}