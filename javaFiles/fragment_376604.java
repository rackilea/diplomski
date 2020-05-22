public View getView(int position, View convertView, ViewGroup parent) {
if (convertView == null) {
    convertView = getActivity().getLayoutInflater()
            .inflate(R.layout.problem_list_row, null);

}
if(position%2==0)
{
    // SET EVEN POSITION COLOR
    convertView.setBackgroundColor(Color.parseColor("#ebebeb"));
}
else
{
   //SET ODD POSITION COLOR
}

/* some code */
return convertView;

}