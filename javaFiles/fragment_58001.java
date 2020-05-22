public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView; (PROBLEM LIES HERE)
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(rowViewResourceId, parent,
                    false);
        }
   // ......
}