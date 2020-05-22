import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Information> data= Collections.emptyList();

    public RecyclerViewAdapter(Context context, List<Information> data){
         this.context=context;
         inflater = LayoutInflater.from(context);
         this.data =data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_raw,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = data.get(position);
        holder.UID.setText(String.valueOf(current.u_id));
        holder.USER.setText(current.user);
        holder.PASS.setText(current.pass);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView UID;
        TextView USER;
        TextView PASS;

        public MyViewHolder(View itemView) {
            super(itemView);
            UID= (TextView) itemView.findViewById(R.id.u_id);
            USER = (TextView) itemView.findViewById(R.id.user);
            PASS = (TextView) itemView.findViewById(R.id.pass);
        }
    }
}