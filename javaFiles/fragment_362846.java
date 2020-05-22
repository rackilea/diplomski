package com.devdwl.stackdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PieChart mChartOuter, mChartInner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mChartOuter = (PieChart) findViewById(R.id.mChartOuter);
        mChartInner = (PieChart) findViewById(R.id.mChartInner);

        mChartOuter.getDescription().setEnabled(false);
        mChartInner.getDescription().setEnabled(false);


        mChartOuter.setCenterTextSize(10f);
        mChartInner.setCenterTextSize(10f);

        mChartOuter.setHoleRadius(75f);
        mChartInner.setHoleRadius(75f);

        mChartOuter.setTransparentCircleRadius(50f);
        mChartInner.setTransparentCircleRadius(50f);

        mChartOuter.getLegend().setEnabled(false);
        mChartInner.getLegend().setEnabled(false);

        setData();

    }

    private void setData() {

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        for (int i = 0; i < 5; i++) {
            entries.add(new PieEntry((float) ((Math.random() * (float) 5) + (float) 5 / 5), i));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mChartOuter.setData(data);
        mChartInner.setData(data);

        mChartOuter.highlightValues(null);
        mChartInner.highlightValues(null);

        mChartOuter.invalidate();
        mChartInner.invalidate();
    }

}