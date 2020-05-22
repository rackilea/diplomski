LinearLayout linearLayout = view.findViewById(R.id.chip_container);
for(int i = 0; i < list.size ; i++){
final View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_chip, null);
    ((TextView) view.findViewById(R.id.chip_text)).setText(list.get(i));
    linearLayout.addView(view);
}