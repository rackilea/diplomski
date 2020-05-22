import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    CombinedChart combinedChart = (CombinedChart) findViewById(R.id.chart1);
    CombinedData data = new CombinedData();
    data.setData(barData());
    data.setData(lineData());
    combinedChart.setData(data);

    // xAxis customization
    XAxis xAxis = combinedChart.getXAxis();

    // Following code have no effect but you can change it if required
    xAxis.setGranularity(1f);
    xAxis.setGranularityEnabled(true);
    xAxis.setCenterAxisLabels(false);
    xAxis.setDrawGridLines(false);

    // Setting maximum limit of xAxis
    xAxis.setAxisMaximum(barData().getEntryCount());

    // Setting position of xAxis
    xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

    // This is used to fix bar width of first bar
    xAxis.setSpaceMin(barData().getBarWidth() / 2f);
    xAxis.setSpaceMax(barData().getBarWidth() / 2f);

    // Setting labels to xAxis
    xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));

}

// creating list of x-axis values 
private ArrayList<String> getXAxisValues()
{
    ArrayList<String> labels = new ArrayList<String> ();

    labels.add( "JAN");
    labels.add( "FEB");
    labels.add( "MAR");
    labels.add( "APR");
    labels.add( "MAY");
    labels.add( "JUN");
    return labels; 
}

// this method is used to create data for line graph 
public LineData lineData()
{
    ArrayList<Entry> line = new ArrayList<Entry> ();
    line.add(new Entry(0, 10));
    line.add(new Entry(1, 11));
    line.add(new Entry(2, 12));
    line.add(new Entry(3, 14));
    line.add(new Entry(4, 18));
    line.add(new Entry(5, 31));

    LineDataSet lineDataSet = new LineDataSet(line, "Brand 2");
    lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
    lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
    lineDataSet.setCircleRadius(5);

    // set this to false to disable the drawing of highlight indicator (lines)
    lineDataSet.setDrawHighlightIndicators(true);
    lineDataSet.setHighLightColor(Color.RED);
    LineData lineData = new LineData(lineDataSet);
    return lineData;
}

// this method is used to create data for Bar graph 
public BarData barData()
{
    ArrayList<BarEntry> group1 = new ArrayList<BarEntry>();
    group1.add(new BarEntry(0, 3));
    group1.add(new BarEntry(1, 1));
    group1.add(new BarEntry(2, 4));
    group1.add(new BarEntry(3, 7));
    group1.add(new BarEntry(4, 3));
    group1.add(new BarEntry(5, 8));

    BarDataSet barDataSet = new BarDataSet(group1, "Brand 1");
    barDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
    //barDataSet.setColor(Color.rgb(0, 155, 0));
    barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

    BarData barData = new BarData(barDataSet);
    //        barData.setBarWidth(0.9f);

    return barData;
}
}