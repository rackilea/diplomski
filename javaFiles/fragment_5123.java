@Override
public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

  int textLength = inputSearch.getText().length();

  if (textLength < 3) return;

  String[] searchPattern = inputSearch.getText().toString().toLowerCase().split("\\s+");

  for (int y = 0; y< allProdString.length; y++) {

    if(textLength <= allProdString[y].length()) {
       if (matchSearch(allProdString[y].toLowerCase(), searchPattern)) {

           allProd_sort.add(allProdString[y]);

       }

    }
 }