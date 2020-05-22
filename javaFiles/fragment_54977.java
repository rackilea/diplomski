if(mEntities.get(position).url.equals("kosong")) {
        Log.e("LOAD", "KOSONG " + position);
        viewHolder.getTextDataView().setText(mEntities.get(position).data);
        //we don't need to display an image here however it's possible that our listview contains another image from a recycled row. Let's clear it
        viewHolder.imageView.setImageResource(android.R.color.transparent);
    }
    else{
        Log.e("LOAD", "ISI " + position);
        Picasso.with(mContext).load(mEntities.get(position).url).skipMemoryCache().into(viewHolder.imageView);
        viewHolder.getTextDataView().setText(mEntities.get(position).data);          
    }