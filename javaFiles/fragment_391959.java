TextView title = (TextView) listItemView.findViewById(R.id.title_text_view);   
TextView author = (TextView) listItemView.findViewById(R.id.author_text_view);



 @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item_view, parent, false);
            }

            Book currentBook = getItem(position);

            TextView title = (TextView) listItemView.findViewById(R.id.title_text_view);
            title.setText(currentBook.getTitle());

            TextView author = (TextView) listItemView.findViewById(R.id.author_text_view);
            author.setText(currentBook.getAuthor());

            return listItemView;
        }