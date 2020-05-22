package com.capitalone.mobile.orx.jchartpoc.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramBin;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.ui.RectangleInsets;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Norbert Powell
 * Created on Dec 21, 2016
 */
@RestController
public class HistogramController {

    public class HistogramPlotGenerator {
        private double upperBound;
        private double minimum;
        private double maximum;
        private int bins = 10;


         public class RelativeSpendRenderer extends XYBarRenderer{

            private static final long serialVersionUID = 1L;
            @Getter @Setter
            private int userSpendLevelBarColumn;
            @Getter @Setter
            private Color userSpendLevelBarColumnColor = new Color(208,48,39);

            public RelativeSpendRenderer(int usplCol) {
                this.userSpendLevelBarColumn = usplCol;
            }

            @Override
            public Paint getItemPaint(int row, int column) {
                if (column == userSpendLevelBarColumn){
                    return  userSpendLevelBarColumnColor;
                }
                return super.getItemPaint(row, column);
            }
         }

         public JFreeChart createHisto(){
                long chartCreationTime = System.currentTimeMillis();
                HistogramDataset histogramDataSet = new HistogramDataset();
                List<Number> spendLevels = 
                        Arrays.asList(12,21,34,3,24,56,7,8,9,100,75,555,65,32,566,700,800,900,307,1000,10201,222,323,444,201,111);
                double userSpendLevelValue = spendLevels.get(10).doubleValue(); // point to be highlighted  
                double [] spls = new double [spendLevels.size()];
                minimum = Double.MAX_VALUE;
                maximum = 0.0;

                for(int i=0; i < spendLevels.size(); i++){
                    double spl = spendLevels.get(i).doubleValue();
                    maximum = Math.max(maximum,spl);
                    minimum = Math.min(minimum, spl);   
                    spls[i] = spl;
                }

                upperBound = 0.0;
                histogramDataSet.addSeries("Spend", spls, bins,minimum,maximum);
                for ( int i=0; i <bins; i++){
                    upperBound = Math.max(histogramDataSet.getYValue(0, i), upperBound);
                }

                JFreeChart barGraph = ChartFactory.createHistogram(null, "$$$", null, histogramDataSet, PlotOrientation.VERTICAL, false, false, false);
                System.out.println("Time to create bar chart: " + (System.currentTimeMillis() - chartCreationTime)+"ms");
                int userSpendBarIndex = getHighlightBar(userSpendLevelValue);
                XYPlot plot = barGraph.getXYPlot();
                plot.setRenderer(new RelativeSpendRenderer(userSpendBarIndex));
                placePointer(histogramDataSet, userSpendBarIndex, plot);
                modifyChart(barGraph);
                return barGraph;            
        }

         private void placePointer(HistogramDataset histogramDataSet,int userSpendBarIndex, XYPlot plot) {
            double x =histogramDataSet.getX(0, userSpendBarIndex).doubleValue();
            double y = histogramDataSet.getY(0, userSpendBarIndex).doubleValue();
            double angle = (3*Math.PI/2);
            XYPointerAnnotation arrow = new XYPointerAnnotation(" ", x, y, angle); 
            arrow.setTipRadius(0); // distance of arrow head from bar  
            arrow.setBaseRadius(10);// distance from arrow head to end of arrow if arrowLength and BaseRadius are > 0 and arrowLength > BaseRadius only the arrow head will be shown
            if (y == upperBound){
                plot.getRangeAxis().setUpperBound(upperBound + arrow.getBaseRadius());
            }else{
                plot.getRangeAxis().setUpperBound(upperBound);
            }
            plot.addAnnotation(arrow);
        }

         private int getHighlightBar(double userSpendValue){
            int highlightBarIndex=0;
            double binWidth = (maximum - minimum) / bins;
            double lower = minimum;
            double upper;
            ArrayList<HistogramBin> binList = new ArrayList<HistogramBin>(bins);
            for (int i = 0; i < bins; i++) {
                HistogramBin bin;
                // make sure bins[bins.length]'s upper boundary ends at maximum
                // to avoid the rounding issue. the bins[0] lower boundary is
                // guaranteed start from min
                if (i == bins - 1) {
                    bin = new HistogramBin(lower, maximum);
                }
                else {
                    upper = minimum + (i + 1) * binWidth;
                    bin = new HistogramBin(lower, upper);
                    lower = upper;
                }
                binList.add(bin);
            }

            for(HistogramBin bin : binList){
                if (userSpendValue >= bin.getStartBoundary() && userSpendValue <= bin.getEndBoundary()){
                    return highlightBarIndex;
                }
                highlightBarIndex++;
            }
            return -1;
        }

         private void modifyChart(JFreeChart chart) {
                Color lineChartColor = new Color(1, 158, 213);

                // plot manipulations
                XYPlot xyPlotModifier = chart.getXYPlot();
                xyPlotModifier.setOutlineVisible(false);
                xyPlotModifier.setRangeMinorGridlinesVisible(false);
                xyPlotModifier.setRangeCrosshairVisible(false);
                xyPlotModifier.setRangeGridlinesVisible(false);
                xyPlotModifier.setRangeZeroBaselineVisible(false);
                xyPlotModifier.setBackgroundPaint(Color.WHITE);
                xyPlotModifier.getDataset().getSeriesCount();

                //Axis modifications
                xyPlotModifier.getRangeAxis().setVisible(false);
                xyPlotModifier.getDomainAxis().setTickLabelsVisible(false);
                xyPlotModifier.getDomainAxis().setMinorTickMarksVisible(false);
                xyPlotModifier.getDomainAxis().setTickMarksVisible(false);
                xyPlotModifier.getDomainAxis().setLabelFont(new Font("SansSerif", Font.PLAIN, 1));  
                xyPlotModifier.setAxisOffset(new RectangleInsets(0.0,0.0,0.0,0.0));

//              Actual data point manipulations
                XYBarRenderer renderer = (XYBarRenderer) xyPlotModifier.getRenderer();
                renderer.setSeriesPaint(0,lineChartColor, true);
                renderer.setBaseOutlinePaint(Color.BLACK, true);
                renderer.setDrawBarOutline(true);
                chart.removeLegend();
            }

    }

    @RequestMapping(value = "getHisto", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getPNGChart(@RequestHeader HttpHeaders headers)throws Exception {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            HistogramPlotGenerator generator = new HistogramPlotGenerator();
            ChartUtilities.writeBufferedImageAsPNG(baos, generator.createHisto().createBufferedImage(352, 90));
            return new ResponseEntity<byte[]>(baos.toByteArray(), HttpStatus.OK);
        }


}