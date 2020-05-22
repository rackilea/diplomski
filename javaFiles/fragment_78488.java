public class AccountListAdapter extends ArrayAdapter<Account> {       
    private List<Account> cuentas;
    private Context context;    

    private static List<Account> createCuentas(Context context)
    {
        AccountListStore loginstore = new AccountListStore(context);
        try {
            return loginstore.getAccounts();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public AccountListAdapter(Context context) {
        this(context, createCuentas(context));
    }


    private AccountListAdapter(Context context, List<Account> cuentas) {
        super(context, R.layout.acount_listadapter, cuentas);
        this.cuentas = cuentas;
    }
}