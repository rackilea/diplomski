LayoutInflater  inflater = LayoutInflater.from(context);
View v = inflater.inflate(R.layout.root_view, null);
Button updateLevel = (Button) v.findViewById(R.id.updateLevel);

updateLevel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setLevelOnClick(v);
        }
    });
Button goBackMainMenu = v.inflate(R.layout.play, null).findViewById(R.id.tomenu);
goBackMainMenu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        toMenuOnClick(v);
    }
});