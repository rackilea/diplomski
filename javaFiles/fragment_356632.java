for( int i = 0; i < N; i++) {
           final int p = i;
           footnoteBtns[p].setOnClickListener(new View.OnClickListener() { 

                @Override 
                public void onClick(View v) {
                    footnote = myDbHelper.getFootnote(chapterNumber,    translationList.get(p).get("transNo")); 
                    popup(); 
                } 
            }); 
}