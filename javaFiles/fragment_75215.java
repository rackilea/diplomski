holder.checked.setVisibility(idpositions.get(position)==0?View.GONE:View.VISIBLE);

    holder.images.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dataSize.size()>0) {

                if (holder.checked.getVisibility() == View.VISIBLE) {

                    holder.checked.setVisibility(View.GONE);

                    dataSize.set(position,0);

                } else if (holder.checked.getVisibility() == View.GONE) {

                    dataSize.add(position,data.getId());

                    holder.checked.setVisibility(View.VISIBLE);

                }

            }
        }
    });