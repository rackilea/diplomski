public class PayListAdapter extends ArrayAdapter<Payment> {

    private List<Payment> items;
    private int layoutResourceId;
    private Context context;

    public PayListAdapter(Context context, int layoutResourceId, List<Payment> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PaymentHolder holder = null;

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new PaymentHolder();
        holder.Payment = items.get(position);
        holder.removePaymentButton = (ImageButton)row.findViewById(R.id.pay_removePay);
        holder.removePaymentButton.setTag(holder.Payment);

        holder.name = (TextView)row.findViewById(R.id.pay_name);
        holder.value = (TextView)row.findViewById(R.id.pay_value);

        row.setTag(holder);

        setupItem(holder);
        return row;
    }

    private void setupItem(PaymentHolder holder) {
        holder.name.setText(holder.Payment.getName());
        holder.value.setText(String.valueOf(holder.Payment.getValue()));
    }

    public static class PaymentHolder {
        Payment Payment;
        TextView name;
        TextView value;
        ImageButton removePaymentButton;
    }
}