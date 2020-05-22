public class AdapterAllProduct extends RecyclerView.Adapter<AdapterAllProduct.AllproductHolder> {



.......

        holder.txt_weight_value.setText(resultItem.getMetadata().getWeightValue());
.......

        holder.btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {