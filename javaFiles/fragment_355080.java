protected void update() {
        check();

if(xx.size() > 0){
        Log.i("tag", xx.get(0));

        System.out.println("Loading Data");

        db.addDaily(new Daily(xx.get(0), xx.get(7), xx.get(8)));

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Editor editor = sharedpreferences.edit();
        editor.putString("Date", xx.get(0));
        editor.commit();
}

}