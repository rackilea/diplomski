import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class UserFragment extends Fragment {

  dataconnect myDB;
  ArrayList < String > items_user;
  ArrayAdapter adapter;
  ListView userList;
  private Context mContext;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_user, container, false);

    mContext = getActivity();
    myDB = new dataconnect(mContext);

    items_user = new ArrayList < > ();
    userList = (ListView) view.findViewById(R.id.listView_users);

    viewData();

    userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView << ? > adapterView, View view, int i, long l) {
        String text = userList.getItemAtPosition(i).toString();
        Toast.makeText(getContext(), "" + text, Toast.LENGTH_SHORT).show();
      }
    });

    return view;
  }

  private void viewData() {
    Cursor cursor = myDB.viewData();

    if (cursor.getCount() == 0) {
      Toast.makeText(getActivity(), "No data to show", Toast.LENGTH_SHORT).show();
    } else {
      while (cursor.moveToNext()) {
        items_user.add(cursor.getString(1));
      }
      adapter = new ArrayAdapter < > (getActivity(), android.R.layout.simple_list_item_1, items_user);
      userList.setAdapter(adapter);
    }
  }

}