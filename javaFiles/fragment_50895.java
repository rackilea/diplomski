arrowbtnright.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(final View v) {
        startActivity(new Intent(CharacterSelect.this, CharacterSelect2.class));

    }
});

contchibtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(final View v) {
        startActivity(new Intent(CharacterSelect.this, MiniChallenge1.class));
    }
});