final int[] score = {0};
final Random generateG1 = new Random();
final int loadG1 = generateG1.nextInt(1000000)+10000;
final TextView number = (TextView) findViewById(R.id.number);
number.setText(" "+loadG1);

final CountDownTimer loop = new CountDownTimer(4000, 1000) {
@Override
public void onTick(long millisUntilFinished) {
}
@Override
public void onFinish() {
    number.setVisibility(View.GONE);
    final TextView prompt = (TextView) findViewById(R.id.prompt);
    prompt.setVisibility(View.VISIBLE);
    prompt.setText(" Enter the number");
    final EditText input = (EditText) findViewById(R.id.enterAnswer);
    input.setVisibility(View.VISIBLE);
    input.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_ENTER:
                        Editable answer = input.getText();
                        int finalAnswer = Integer.parseInt(String.valueOf(answer));
                        // here we get from text field the current correct value
                        int finalLoadG1 = Integer.parseInt(String.valueOf(number.getText()));
                        input.setVisibility(View.GONE);
                        prompt.setVisibility(View.GONE);
                        if (finalAnswer == finalLoadG1) {
                            score[0]++;
                        }

                        number.setVisibility(View.VISIBLE);
                        final int loadG1 = generateG1.nextInt(1000000) + 10000;
                        number.setText(" " + loadG1);
                        input.getText().clear();

                        start();

                        return true;
                    default:
                }
            }
            return false;
        }
    });
}
}.start();

new CountDownTimer(24000, 1000) {
@Override
public void onTick (long millisUntilFinished) {
}
@Override
public void onFinish() {
    TextView result = (TextView) findViewById(R.id.outcome);
    result.setText("Score: "+ score[0]);
    TextView prompt = (TextView) findViewById(R.id.prompt);
    prompt.setVisibility(View.GONE);
    final EditText input = (EditText) findViewById(R.id.enterAnswer);
    input.setVisibility(View.GONE);
    loop.cancel();
}
}.start();