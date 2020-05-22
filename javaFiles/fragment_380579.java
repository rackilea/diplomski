package com.steema.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.steema.teechart.TChart;
import com.steema.teechart.styles.Bar;
import com.steema.teechart.styles.Pie;
import com.steema.teechart.themes.ThemesList;

public class AndroidTestActivity extends Activity implements OnItemSelectedListener{

    private TChart tChart1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout group = (LinearLayout) findViewById(R.id.linearLayoutTchart);

        tChart1 = new TChart(this);
        group.addView(tChart1);
        ThemesList.applyTheme(tChart1.getChart(), 1);

        Spinner spinner = (Spinner) findViewById(R.id.series_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.series_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        tChart1.setAutoRepaint(false);
        tChart1.removeAllSeries();
        switch (arg2) {
        case 0:
            Bar bar1 = new Bar(tChart1.getChart());
            bar1.fillSampleValues();
            tChart1.getLegend().setVisible(true);
            break;
        case 1:
            Pie pie1 = new Pie(tChart1.getChart());
            pie1.fillSampleValues();
            tChart1.getLegend().setVisible(false);
            break;
        }
        tChart1.setAutoRepaint(true);
        tChart1.refreshControl();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}