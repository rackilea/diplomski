show_random.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        char c = chars[random.nextInt(chars.length)];
        letters.setText(Character.toString(c)); 
    }
});