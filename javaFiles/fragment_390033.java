int myTagCount=0;

public void onAddField(View v) {

               myTagCount++;

                LayoutInflater inflater = LayoutInflater.from(getContext());

                View view = inflater.inflate(R.layout.product_specification_item_layout, null);

                TextView tv_delete = (TextView) view.findViewById(R.id.tv_delete);
                tv_delete.setText("Delete");

                tv_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         parentLinearLayout.removeView(view);
                    }
                });

                view.setTag(myTagCount);

                parentLinearLayout.addView(view);

   }