char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
 StringBuilder sb = new StringBuilder(26);
 Random random = new Random();

 show_random.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        char c = chars[random.nextInt(chars.length)];
        sb.append(c);
        final String output = sb.toString();
        letters.setText(output); 
    }
});