package pl.psnc.iip.hne.android.hneclient.adapter;
import java.util.ArrayList;
import pl.psnc.iip.hne.android.hneclient.R;
import pl.psnc.iip.hne.android.hneclient.json.Device;
import pl.psnc.iip.hne.android.hneclient.json.Devices;
import pl.psnc.iip.hne.android.hneclient.listeners.ImageViewRegisteredListener;
import pl.psnc.iip.hne.android.hneclient.utility.ConnectionUtils;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

public class DeviceExpandableListAdapter extends BaseExpandableListAdapter {

public ArrayList<String> groupItem;
public ArrayList<Device> tempChild;
public ArrayList<Object> childItem;
public LayoutInflater minflater;

ArrayList<ImageViewRegisteredListener> ivrListeners = null;
public Activity activity;
public Context context;
int idIterator;

public void addImageViewRegisteredListener(
    ImageViewRegisteredListener listener) {
if (!ivrListeners.contains(listener)) {
    ivrListeners.add(listener);
}
}

public void removeImageViewRegisteredListener(
    ImageViewRegisteredListener listener) {
if (ivrListeners.contains(listener)) {
    ivrListeners.remove(listener);
}
}

public DeviceExpandableListAdapter(ArrayList<String> grList,
    ArrayList<Object> childItem, Context context) {
groupItem = grList;
idIterator = 0;
ivrListeners = new ArrayList<ImageViewRegisteredListener>();
this.childItem = childItem;
this.context = context;

minflater = (LayoutInflater) context
    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

}

public void setInflater(LayoutInflater mInflater, Activity act) {
this.minflater = mInflater;
activity = act;
}

public int findAppropriateImageForDevice(String type) {
int id = -1;
if (type.equals(Devices.PLOGG)) {
    id = R.drawable.plogg;
} else if (type.equals(Devices.RFID)) {
    id = R.drawable.rfid;
} else if (type.equals(Devices.BARRIER)) {
    // id = -1;
} else if (type.equals(Devices.TEMPLIGHT)) {
    // id = -1;
}
return id;
}

@Override
public Object getChild(int groupPosition, int childPosition) {
return (Device) ((ArrayList<Device>) childItem.get(groupPosition))
    .get(childPosition);
}

@Override
public long getChildId(int groupPosition, int childPosition) {
return 0;
}

@Override
public View getChildView(int groupPosition, final int childPosition,
    boolean isLastChild, View convertView, ViewGroup parent) {
tempChild = (ArrayList<Device>) childItem.get(groupPosition);
Device device = tempChild.get(childPosition);
Log.i(this.getClass().getName(), device.getIp());
if (groupItem.get(groupPosition).equals(Devices.PLOGG)) {
    int newId = -1;
    Integer oldId = ConnectionUtils.getInstance().getPowerIndicatorHT()
        .get(device.getIp());
    if (oldId != null) {
    newId = oldId;
    } else {
    ++idIterator;
    newId = idIterator;
    ConnectionUtils.getInstance().getPowerIndicatorHT()
        .put(device.getIp(), newId);
    }
    convertView = minflater.inflate(R.layout.plogg_item, null);
    ImageView powerIndicator = (ImageView) convertView
        .findViewById(R.id.powerIndicator);

    powerIndicator.setId(newId);

    Integer foundId = ConnectionUtils.getInstance()
        .getPowerIndicatorHT().get(device.getIp());
    if (foundId != null) {
    for (ImageViewRegisteredListener listener : ivrListeners) {
        listener.imageViewRegistered(convertView, foundId,
            device.getIp());
    }
    }

    Log.i(DeviceExpandableListAdapter.class.getName(), "newId: "
        + newId);

} else {
    convertView = minflater.inflate(R.layout.device_item, null);
}
TextView textTop = null;
textTop = (TextView) convertView.findViewById(R.id.toptext);
TextView textBottom = null;
textBottom = (TextView) convertView.findViewById(R.id.bottomtext);

textTop.setText(device.getIp());
textBottom.setText(device.getDescription());

int id = findAppropriateImageForDevice(device.getType());
ImageView image = (ImageView) convertView.findViewById(R.id.icon);
if (id != -1) {
    image.setImageResource(id);
} else {
    image.setImageResource(R.drawable.ic_launcher);
}

return convertView;
}

@Override
public int getChildrenCount(int groupPosition) {
return ((ArrayList<String>) childItem.get(groupPosition)).size();
}

@Override
public Object getGroup(int groupPosition) {
return null;
}

@Override
public int getGroupCount() {
return groupItem.size();
}

@Override
public void onGroupCollapsed(int groupPosition) {
super.onGroupCollapsed(groupPosition);
}

@Override
public void onGroupExpanded(int groupPosition) {
super.onGroupExpanded(groupPosition);
}

@Override
public long getGroupId(int groupPosition) {
return 0;
}

@Override
public View getGroupView(int groupPosition, boolean isExpanded,
    View convertView, ViewGroup parent) {
if (convertView == null) {
    convertView = minflater.inflate(R.layout.group_row, null);
}
CheckedTextView ctv = (CheckedTextView) convertView
    .findViewById(R.id.textView1);
ctv.setText(groupItem.get(groupPosition));
ctv.setChecked(isExpanded);
return convertView;
}

@Override
public boolean hasStableIds() {
return false;
}

@Override
public boolean isChildSelectable(int groupPosition, int childPosition) {
return true;
}

}