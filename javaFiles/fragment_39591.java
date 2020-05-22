import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_chart.view.*
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


/**
 * A simple [Fragment] subclass.
 *
 */
class ChartFragment : BaseFragment() {

    lateinit var mChart: BarChart
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_insigts, container, false)

        rootView.tvInflow.text = changeTextSizeOfAvailableBalance("198.12")
        rootView.tvOutFlow.text = changeTextSizeOfAvailableBalance("198.12")


        mChart = rootView.barChart
        getEntries()

        return rootView
    }

    private fun changeTextSizeOfAvailableBalance(price: String): SpannableStringBuilder {
        val spannableStringBuilder = SpannableStringBuilder("N")
        val spannable = SpannableString(price)
        spannable.setSpan(RelativeSizeSpan(2f), 0, spannable.length, 0)
        spannableStringBuilder.append(spannable)
        return spannableStringBuilder
    }

    private fun getEntries() {
        mChart.setDrawBarShadow(false)
        mChart.description.isEnabled = false
        mChart.setPinchZoom(false)
        mChart.setDrawGridBackground(false)

        val labels = arrayOf("", "JAN", "FEB", "MAR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC", "")

        val xAxis = mChart.xAxis
        xAxis.setCenterAxisLabels(true)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f // only intervals of 1 day
        xAxis.textColor = Color.BLACK
        xAxis.textSize = 11f
        xAxis.axisLineColor = Color.WHITE
        xAxis.axisMinimum = 1f
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        xAxis.position = XAxis.XAxisPosition.TOP

        val leftAxis = mChart.axisLeft
        leftAxis.textColor = Color.BLACK
        leftAxis.textSize = 12f
        leftAxis.axisLineColor = Color.WHITE
        leftAxis.setDrawGridLines(false)
        leftAxis.granularity = 2f
        leftAxis.setLabelCount(8, true)
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)

        mChart.axisRight.isEnabled = false
        mChart.legend.isEnabled = false

        val valOne = floatArrayOf(10f, 20f, 44f, 40f, 50f, 50f, 52f, 30f, 40f, 50f, 40f, 30f)
        val valTwo = floatArrayOf(20f, 10f, 50f, 30f, 52f, 52f, 50f, 40f, 30f, 40f, 30f, 30f)

        val barOne = ArrayList<BarEntry>()
        val barTwo = ArrayList<BarEntry>()

        for (i in 0 until valOne.size) {
            barOne.add(BarEntry(i.toFloat(), valOne[i]))
            barTwo.add(BarEntry(i.toFloat(), valTwo[i]))
        }

        val set1 = BarDataSet(barOne, "barOne")
        set1.color = Color.GRAY
        val set2 = BarDataSet(barTwo, "barTwo")
        set2.color = Color.BLUE


        set1.isHighlightEnabled = false
        set2.isHighlightEnabled = false
        set1.setDrawValues(false)
        set2.setDrawValues(false)

        mChart.axisLeft.setDrawLabels(false)
        mChart.axisRight.setDrawLabels(false)

        val dataSets = ArrayList<IBarDataSet>()
        dataSets.add(set1)
        dataSets.add(set2)
        val data = BarData(dataSets)
        val groupSpace = 0.4f
        val barSpace = 0f
        val barWidth = 0.3f
        data.barWidth = barWidth
        xAxis.axisMaximum = labels.size - 1.1f
        mChart.data = data
        mChart.setScaleEnabled(false)
        mChart.setVisibleXRangeMaximum(4f)
        mChart.groupBars(1f, groupSpace, barSpace)
        mChart.invalidate()
    }


}