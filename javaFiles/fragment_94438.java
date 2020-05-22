import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout_example);
        hideSystemUI();
        initTabs();
        initRecycler();
    }

    private void initTabs() {
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 3"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 4"));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TabLayoutExample.this, "Tab " + tab.getPosition() + " Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initRecycler() {
        List<String> listData = new ArrayList<>();
        ExampleAdapter exampleAdapter = new ExampleAdapter(listData);
        RecyclerView mRecyclerVIew = (RecyclerView) findViewById(R.id.recyclerVIew);
        mRecyclerVIew.setAdapter(exampleAdapter);
        for (int i = 0; i < 30; i++) {
            listData.add("Android " + i);
        }
        exampleAdapter.notifyDataSetChanged();
    }

    class ExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<String> list;

        public ExampleAdapter(List<String> list) {
            this.list = list;
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ExampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            ExampleViewHolder exampleViewHolder = (ExampleViewHolder) viewHolder;
            exampleViewHolder.bindData();
        }

        public class ExampleViewHolder extends RecyclerView.ViewHolder {

            protected TextView mText;

            public ExampleViewHolder(View view) {
                super(view);
                this.mText = (TextView) view.findViewById(android.R.id.text1);
            }

            public void bindData() {
                String dataItem = list.get(getAdapterPosition());
                mText.setText(dataItem);
            }
        }
    }

    // Ignore, just for removing systemUI bars(Full Screen)
    private void hideSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }
}