import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Paint;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class GroupedListAdapter extends BaseAdapter
{
    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_GROUP  = 1;
    private static final int MAX_TYPES   = 2;

    private final Context              mContext;
    private final LayoutInflater       mInflater;
    private final ContactManager       mContactManager;
    private final ArrayList<GroupItem> mItems          = new ArrayList<GroupItem>();
    private final DataSetObserver      mDataSetObserver = new MyDataSetObserver();

    private boolean mDataValid = false;
    private Cursor  mCursor    = null;

    private int mIndexId;
    private int mIndexSummary;
    private int mIndexType;
    private int mIndexSender;
    private int mIndexReciever;
    private int mIndexCompleted;
    private int mIndexCompletedBy;



    public GroupedListAdapter(Context context)
    {
        mContext = context;
        mContactManager = new ContactManager(context);
        mInflater = LayoutInflater.from(context);
    }

    public void changeCursor(Cursor newCursor)
    {
        if(newCursor == mCursor){
            return;
        }
        Cursor oldCursor = mCursor;
        if(oldCursor != null) {
            if(mDataSetObserver != null){
                oldCursor.unregisterDataSetObserver(mDataSetObserver);
            }
        }
        mCursor = newCursor;
        if(newCursor != null){
            if(mDataSetObserver != null){
                newCursor.registerDataSetObserver(mDataSetObserver);
            }

            mIndexId          = newCursor.getColumnIndexOrThrow(DatabaseContract.Task.Columns._ID);
            mIndexSummary     = newCursor.getColumnIndexOrThrow(DatabaseContract.Task.Columns.SUMMARY);
            mIndexType        = newCursor.getColumnIndexOrThrow(DatabaseContract.Task.Columns.TYPE);
            mIndexSender      = newCursor.getColumnIndexOrThrow(DatabaseContract.Task.Columns.SENDER);
            mIndexReciever    = newCursor.getColumnIndexOrThrow(DatabaseContract.Task.Columns.RECIEVER);
            mIndexCompleted   = newCursor.getColumnIndexOrThrow(DatabaseContract.Task.Columns.COMPLETED);
            mIndexCompletedBy = newCursor.getColumnIndexOrThrow(DatabaseContract.Task.Columns.COMPLETED_BY);

            // calculate types and index mappings

            /*
             * 1. Sent (5)
             * 2. Item 5
             * 3. Item 6
             * 4. Received (9)
             * 5. Item 9
             * 6. Today (1)
             * 7. Item 1
             * 8. Item 2
             * 9. Item 3
             * 
             */

            // allocate 
            int count = newCursor.getCount();
            mItems.ensureCapacity(count);
            if(newCursor.moveToFirst()){
                int i = 0;
                do{
                    mItems.add(new GroupItem(getGroupId(newCursor), i, TYPE_NORMAL));
                    i++;
                }while(newCursor.moveToNext());
            }

            Collections.sort(mItems);

            int lastGroupId = -1;
            for(int i = 0; i < mItems.size(); i++){
                final GroupItem item = mItems.get(i);
                if(lastGroupId != item.group_id){
                    mItems.add(i, new GroupItem(item, TYPE_GROUP));
                    lastGroupId = item.group_id;
                }
            }

            mDataValid = true;

            // notify the observers about the new cursor
            notifyDataSetChanged();
        }
        else{
            mDataValid = false;

            mIndexId          = -1;
            mIndexSummary     = -1;
            mIndexType        = -1;
            mIndexSender      = -1;
            mIndexReciever    = -1;
            mIndexCompleted   = -1;
            mIndexCompletedBy = -1;

            mItems.clear();

            // notify the observers about the lack of a data set
            notifyDataSetInvalidated();
        }

        if(oldCursor != null) {
            oldCursor.close();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(!mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }

        GroupItem item = mItems.get(position);

        if(!mCursor.moveToPosition(item.position)) {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }

        final View view;
        if(convertView == null) {
            if(item.type == TYPE_GROUP){
                view = mInflater.inflate(R.layout.main_list_group, parent, false);
            }
            else if(item.type == TYPE_NORMAL){
                view = mInflater.inflate(R.layout.main_list_item, parent, false);
            }
            else{
                throw new IllegalStateException("Bad TaskItem type");
            }
        }
        else{
            view = convertView;
        }


        if(item.type == TYPE_GROUP){
            TextView textGroup = (TextView)view.findViewById(R.id.task_group);
            textGroup.setText(mContext.getString(item.group_id));
        }
        else if(item.type == TYPE_NORMAL){
            TextView textTitle = (TextView)view.findViewById(R.id.task_title);
            TextView textDescr = (TextView)view.findViewById(R.id.task_description);

            String desc;

            String type  = mCursor.getString(mIndexType);
            if(type.equals(DatabaseContract.Task.TASK_TYPE_OWNER)){
                desc = mContext.getString(R.string.desc_example);
            }
            else if(type.equals(DatabaseContract.Task.TASK_TYPE_RECEV)){
                final String sender = mCursor.getString(mIndexSender);
                final String name = mContactManager.getContactName(sender);
                desc = (name != null) ? name : sender;
            }
            else{
                final String receiver = mCursor.getString(mIndexReciever);
                final String name = mContactManager.getContactName(receiver);
                desc = (name != null) ? name : receiver;
            }

            textDescr.setText(desc);

            String title = mCursor.getString(mIndexSummary);
            textTitle.setText(Character.toUpperCase(title.charAt(0)) + title.substring(1));
            if(mCursor.getInt(mIndexCompleted) != 0){
                textTitle.setPaintFlags(textTitle.getPaintFlags() |  Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else{
                textTitle.setPaintFlags(textTitle.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
            }
        }

        return view;
    }

    @Override
    public Cursor getItem(int position)
    {
        if(mDataValid && mCursor != null){
            mCursor.moveToPosition(mItems.get(position).position);
            return mCursor;
        }
        else{
            return null;
        }
    }

    @Override
    public long getItemId(int position)
    {
        if(mDataValid && mCursor != null){
            if(mCursor.moveToPosition(mItems.get(position).position)){
                return mCursor.getLong(mIndexId);
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position)
    {
        if(mDataValid && mCursor != null){
            return mItems.get(position).type;
        }
        else{
            return IGNORE_ITEM_VIEW_TYPE;
        }
    }

    @Override
    public int getViewTypeCount()
    {
        return MAX_TYPES;
    }

    @Override
    public int getCount()
    {
        if(mDataValid && mCursor != null){
            return mItems.size();
        }
        else{
            return 0;
        }
    }

    public Cursor getCursor()
    {
        return mCursor;
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    private int getGroupId(Cursor c)
    {
        if(c.getString(mIndexType).equals(DatabaseContract.Task.TASK_TYPE_SENT)){
            return R.string.group_sent;
        }
        else if(c.getString(mIndexType).equals(DatabaseContract.Task.TASK_TYPE_RECEV)){
            return R.string.group_received;
        }
        else{
            long time  = c.getLong(mIndexCompletedBy);
            long delta = (time - System.currentTimeMillis());

            if(delta <= DateUtils.HOUR_IN_MILLIS){
                return R.string.group_asap;
            }
            else if(delta <= DateUtils.DAY_IN_MILLIS){
                return R.string.group_today;
            }
            else if(delta <= (DateUtils.DAY_IN_MILLIS * 2)){
                return R.string.group_tomorrow;
            }
            else if(delta <= DateUtils.WEEK_IN_MILLIS){
                return R.string.group_this_week;
            }
            else if(delta <= (DateUtils.WEEK_IN_MILLIS * 2)){
                return R.string.group_next_week;
            }
            else{
                return R.string.group_someday;
            }
        }
    }

    private class MyDataSetObserver extends DataSetObserver
    {
        @Override
        public void onChanged()
        {
            mDataValid = true;
            notifyDataSetChanged();
        }

        @Override
        public void onInvalidated()
        {
            mDataValid = false;
            notifyDataSetInvalidated();
        }
    }

    private static class GroupItem implements Comparable<GroupItem>
    {
        public int group_id;
        public int position;
        public int type;


        public GroupItem(int group_id, int position, int type)
        {
            this.group_id = group_id;
            this.position = position;
            this.type     = type;
        }

        public GroupItem(GroupItem item, int type)
        {
            this.group_id = item.group_id;
            this.position = item.position;
            this.type     = type;
        }

        @Override
        public int compareTo(GroupItem another)
        {
            return group_id < another.group_id ? -1 : (group_id == another.group_id ? 0 : 1);
        }
    }
}