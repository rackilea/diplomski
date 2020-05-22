String title; //your title

//find length of your title
int length = title.length();

if (length>16){
string[] titles = myString.split("\\s+");

int size = titles.length;

if (size < 2){
      yourTextview.setText(title);
   // reduce the text size of your textview
}else {
  String newTitle= "";
for (int i=0;i<titles.length;i++){
  newTitle = titles[i]+"\n"
}
  yourTextview.setText(newTitle);

}
}