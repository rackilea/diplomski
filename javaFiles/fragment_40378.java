@Override
protected void onBindViewHolder(FilmsViewHolder filmsViewHolder, int i, Films films) {

    filmsViewHolder.mFilmName.setText(films.getName());
    filmsViewHolder.mFilmYear.setText(String.valueOf(films.getYear()));
}