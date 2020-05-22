if (Arrays.equals(actionPosition, actualPosition)) {

    Toast.makeText(MainActivity.this, "matched!", Toast.LENGTH_SHORT).show();
    for (int index = 0; index<actionPosition.length; index++){
         // use the getChildAt(index) to get the views in a ListView
         View counter = (View) myListView.getChildAt(index);
         counter.setVisibility(View.VISIBLE);
    }

}