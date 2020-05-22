private void check() {
    int n;
    try {
        System.out.println(primeTestField.getText());
        n = Integer.parseInt(primeTestField.getText());
    } catch (Exception ex) {
        return;
    }
    if (n == 2) {
        trueFalseLabel.setText("Yes");
    } else {
        boolean isPrime = true;
        for (int i = 2; 2 * i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            trueFalseLabel.setText("Yes");
        } else {
            trueFalseLabel.setText("No");
        }
    }
}