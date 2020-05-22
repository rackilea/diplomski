// Declaring the filteredList as a public variable that can be accessed from anywhere in this class.
public ArrayList<String> filteredList = new ArrayList<>();

@Override
public void onItemClick(int position) {
    Intent intent = new Intent(this, singleActivity.class);

    // Get the item from the filteredList which is the updated one.
    hisItem clickeditem = filteredList.get(position);

    String pos = String.valueOf(position);
    intent.putExtra(CARD_NUM ,pos );
    intent.putExtra(HEAD_LINE,clickeditem.getText1());
    intent.putExtra(REAL_NUM,clickeditem.getText3());
    startActivity(intent);
}