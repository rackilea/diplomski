private static String getLineContent(String value) {
    return value.substring(value.indexOf(' ') + 1);
}

public static void main(String[] args) {
    BufferedReader in;
    try {
        in = new BufferedReader(new FileReader("filefullofmoney.txt"));
    } catch (FileNotFoundException ex) {
        // TODO: Handle the error with a nice error message.
        return;
    }

    List<Account> accounts = new ArrayList<Account>();

    while (true) {
        try {
            String accountName = in.readLine();

            if (accountName == null) {
                // We have no new accounts. So we exit.
                break;
            }

            accountName = getLineContent(accountName);
            int pin = Integer.parseInt(getLineContent(in.readLine()));
            double balance = Double.parseDouble(getLineContent(in.readLine()));

            accounts.add(new Account(accountName, pin, balance));
        } catch (IOException ex) {
            // TODO: Handle the error with a nice message saying that the file is malformed.
        }
    }
}

class Account {

    public String accountName;
    public int pin;
    public double balance;

    public Account(String accountName, int pin, double balance) {
        this.accountName = accountName;
        this.pin = pin;
        this.balance = balance;
    }
}