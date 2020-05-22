import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;

import com.chimmerltd.chimmer.ChimmerActivity.CommomImageLoader;
import com.chimmerltd.chimmer.R;
import com.chimmerltd.customControls.ChimmerRoundedImageView;
import com.chimmerltd.customControls.ChimmerTextView;
import com.chimmerltd.models.AuthenticationResponse;
import com.chimmerltd.models.ContactSynRequestcontacts;
import com.chimmerltd.models.ContactSynResponse;
import com.chimmerltd.utility.Constants;

public class SyncContactsAdapter extends ArrayAdapter<ContactSynResponse> {

    private Context context;
    public String type = null;
    private ViewHolder viewHolder;
    private SparseBooleanArray mSparseBooleanArray;
    private List<ContactSynResponse> mList;
    List<ContactSynRequestcontacts> contactdata;


    public SyncContactsAdapter(Context context, int resource,
            List<ContactSynResponse> getdata) {
        super(context, resource, getdata);
        this.context = context;

        mSparseBooleanArray = new SparseBooleanArray();

    }

    @Override
    public ContactSynResponse getItem(int position) {
        return super.getItem(position);
    }

    public ArrayList<ContactSynResponse> getCheckedItems() {
        ArrayList<ContactSynResponse> mTempArry = new ArrayList<ContactSynResponse>();

        for (int i = 0; i < mList.size(); i++) {
            if (mSparseBooleanArray.get(i)) {
                ContactSynResponse data = mList.get(i);

                mTempArry.add(data);

            }
        }

        return mTempArry;
    }

    class ViewHolder {

        ChimmerTextView contactname;
        ChimmerTextView contactno;
        ChimmerTextView unblockfriendTV;
        RelativeLayout completelayout;
        CheckBox selectcheckbox;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.sharedcontactlistdata,
                    parent, false);
            viewHolder = new ViewHolder();


            viewHolder.contactname = (ChimmerTextView) convertView
                    .findViewById(R.id.contactnameTV);
            viewHolder.contactno = (ChimmerTextView) convertView
                    .findViewById(R.id.contactnoTV);
            viewHolder.completelayout = (RelativeLayout) convertView
                    .findViewById(R.id.completeRL);
            viewHolder.selectcheckbox = (CheckBox) convertView
                    .findViewById(R.id.contact_checkbox);

            viewHolder.unblockfriendTV = (ChimmerTextView) convertView
                    .findViewById(R.id.unblockfriendTV);
            convertView.setTag(viewHolder);
            if (type.equalsIgnoreCase(Constants.BLOCK_CONTACT)) {
                viewHolder.selectcheckbox.setVisibility(View.INVISIBLE);
            }
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ContactSynResponse data = getItem(position);
        viewHolder.contactname.setText(data.getName());
        viewHolder.contactno.setText(data.getPhone());
        viewHolder.selectcheckbox.setTag(position);

        viewHolder.selectcheckbox.setOnCheckedChangeListener(new CheckchangeListener(data,
                        viewHolder.selectcheckbox));
        if (data.isSelected()) {
            viewHolder.selectcheckbox
                    .setButtonDrawable(R.drawable.notification_selected_checkbox);
            mSparseBooleanArray.put((Integer) viewHolder.selectcheckbox.getTag(), data.isSelected());
        } else {
            viewHolder.selectcheckbox
                    .setButtonDrawable(R.drawable.notification_checkbox);
            mSparseBooleanArray.put((Integer) viewHolder.selectcheckbox.getTag(), data.isSelected());
        }

        if (data.getIsBlocked() == 1) {
            viewHolder.unblockfriendTV.setVisibility(View.VISIBLE);

        } else {
            viewHolder.unblockfriendTV.setVisibility(View.GONE);


        }

        viewHolder.completelayout.setOnClickListener(new CompleteLayoutClickListener(data,viewHolder.selectcheckbox));
        return convertView;

    }

    class CompleteLayoutClickListener implements OnClickListener {

        private ContactSynResponse data;
        private CheckBox checkbox;
        public CompleteLayoutClickListener(ContactSynResponse  data,CheckBox checkbox) {
        this.data=data;
        this.checkbox=checkbox;
        }
        @Override
        public void onClick(View v) {
if(data.isSelected())
{
data.setSelected(false);
checkbox.setChecked(false);
mSparseBooleanArray.put((Integer) checkbox.getTag(), false);
}
else
{
    data.setSelected(true);
    checkbox.setChecked(true);
    mSparseBooleanArray.put((Integer) checkbox.getTag(), true);
}
        }

    }

    class CheckchangeListener implements OnCheckedChangeListener {

        private CheckBox checkbox;
        private ContactSynResponse data;

        public CheckchangeListener(ContactSynResponse data, CheckBox checkbox) {

            this.checkbox = checkbox;
            this.data = data;

        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                boolean isChecked) {
            if (isChecked) {
                checkbox.setButtonDrawable(R.drawable.notification_selected_checkbox);
            } else {
                checkbox.setButtonDrawable(R.drawable.notification_checkbox);
            }
            buttonView.setChecked(isChecked);
            data.setSelected(isChecked);
            mSparseBooleanArray.put((Integer) buttonView.getTag(), isChecked);

        }
    }

}


model class :-

public class ContactSynResponse {

    private long id;
    private long UserId;
    private String Name;
    private String Phone;
    private String ProfilePhoto;
    private int isBlocked;
    private boolean isSelected;

    private Bitmap profileBitmap;


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getProfilePhoto() {
        return ProfilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        ProfilePhoto = profilePhoto;
    }

    public int getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(int isBlocked) {
        this.isBlocked = isBlocked;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public Bitmap getProfileBitmap() {
        return profileBitmap;
    }

    public void setProfileBitmap(Bitmap profileBitmap) {
        this.profileBitmap = profileBitmap;
    }

}


layout used:-


<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/completeRL"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="10dp" >



    <TextView
        android:id="@+id/contactnameTV"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignTop="@+id/profilepic_image_view"
        android:layout_marginLeft="10dp"
        android:layout_marginTop="15dp"
        android:layout_toRightOf="@+id/profilepic_image_view"
        android:text="@string/about" />

    <TextView
        android:id="@+id/contactnoTV"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/profilepic_image_view"
        android:layout_alignLeft="@+id/contactnameTV"
        android:layout_marginBottom="15dp"
        android:text="@string/about" />

    <CheckBox
        android:id="@+id/contact_checkbox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        android:layout_alignTop="@+id/contactnameTV"
        android:layout_marginRight="10dp"
        android:onClick="onClick"
        android:button="@drawable/notification_checkbox" />

    <TextView
        android:id="@+id/unblockfriendTV"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/contactnoTV"
        android:layout_marginTop="5dp"
        android:layout_alignParentRight="true"
        android:text="@string/unblock_friend_message"
        android:visibility="gone"
        android:textColor="@color/grey" />

</RelativeLayout>