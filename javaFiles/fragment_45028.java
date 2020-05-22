@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_invoice,parent,false);
    ViewHolder viewHolder = new ViewHolder(view);

    viewHolder.button_inc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Products product = addedProductsList.get(getAdapterPosition());

            product.setQty( product.getQty() + 1 );

            float difference = product.isPrice_g_enabled() ? Float.parseFloat(product.getPrice_g()) : Float.parseFloat(product.getPrice());

            mListener.onQuantityChange( difference );

            notifyItemChanged( getAdapterPosition ):// This will call onBindViewAdapter again and change all your strings for you

        }
    });

    viewHolder.button_dec.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Products product = addedProductsList.get(getAdapterPosition());

            if( product.getQty() == 0 )// Can't remove an item if it's already at 0
                return;

            product.setQty( product.getQty() - 1 );

            float difference = product.isPrice_g_enabled() ? Float.parseFloat(product.getPrice_g()) : Float.parseFloat(product.getPrice());

            mListener.onQuantityChange( -difference );

            notifyItemChanged( getAdapterPosition ):// This will call onBindViewAdapter again and change all your strings for you

        }
    });

    viewHolder.button_cancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Products product = addedProductsList.get(getAdapterPosition());

            float difference = product.isPrice_g_enabled() ? Float.parseFloat(product.getPrice_g()) : Float.parseFloat(product.getPrice());

            mListener.onQuantityChange( -difference * product.getQty() );

            product.setQty( 0 );

            notifyItemChanged( getAdapterPosition ):// This will call onBindViewAdapter again and change all your strings for you

            // You decide at this point if you want to remove the item altogether or just show 0

        }
    });

    return viewHolder;
}