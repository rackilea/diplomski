public void showRecipes(View view) {

   Intent i = new Intent(getContext(), ShowRecipes.class);
            Bundle args = new Bundle(); /// nu reusesc sa transfer obiectele
            args.putSerializable("ARRAYLIST",listaIngrediente);
            i.putExtra("BUNDLE",args);
            startActivity(i);
}