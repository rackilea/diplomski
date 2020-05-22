public class MyClickListener implements AdapterView.OnItemClickListener{

List<MyDataModel> datas;

public MyClickListener(List<MyDataModel> datas)
{

    this.datas = datas;
}

@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);

    //--> this was a problem--> datas = new ArrayList<MyDataModel>();

    if (position < datas.size())
    {
        MyDataModel data = datas.get(position);
        intent.putExtra(Key.KEY_ID,data.getItemId());
        intent.putExtra(Key.KEY_ABOUT,data.getAbout());
        intent.putExtra(Key.KEY_ADDRESS,data.getAddress());
        intent.putExtra(Key.KEY_COMPANY,data.getCompany());
        intent.putExtra(Key.KEY_EMAIL,data.getEmail());
        intent.putExtra(Key.KEY_FIRST_NAME,data.getFirstName());
        intent.putExtra(Key.KEY_LAST_NAME,data.getLastName());
        intent.putExtra(Key.KEY_PHONE,data.getPhone());

        view.getContext().startActivity(intent);
    }
}