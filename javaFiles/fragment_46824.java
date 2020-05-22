@Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView;
            Selfie selfie = selfies.get(position);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) parent.getContext().
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowView = inflater.inflate(R.layout.row, parent, false);
            } else {
                rowView = convertView;
            }
            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
            imageView.setImageBitmap(selfie.getSelfieBitmap());
            TextView textView = (TextView) rowView.findViewById(R.id.text);
            textView.setText(selfie.getSelfieName());

            return rowView;
        }