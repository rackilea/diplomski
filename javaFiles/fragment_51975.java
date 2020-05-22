Submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Input = UserInput.getText().toString();
        Random random = new Random();
        String[] List = Input.split(",");
        int num = random.nextInt(List.length - 1);
        word = List[num];
        Result = Result + word;
        result.setText(Result);
    }
}