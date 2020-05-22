import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    String [] Text;
    int [] Image;
    Context context;

    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] TextItem, int[] mainImages) {
        Text = TextItem;
        context = mainActivity;
        Image = mainImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    // Get number of items in list
    public int getCount() {
        return Text.length;
    }

    @Override
    // Get position of item in list
    public Object getItem(int position) {
        return position;
    }

    @Override
    // ???
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.YOURCUSTOMXML, null);

        /** Get relevant view
         * Set image/text resource, based on list name, based on list position
         */
        holder.img=(ImageView) rowView.findViewById(R.id.IMAGEIDINCUSTOMXML);
        holder.img.setImageResource(Image[position]);

        holder.tv=(TextView) rowView.findViewById(R.id.TEXTIDINCUSTOMXML);
        holder.tv.setText(Text[position]);

        return rowView;
    }

}