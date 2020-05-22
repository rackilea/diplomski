import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class SemiCircleChart extends Parent{ //TODO: this should extend Chart in the future
    private List<Data> dataList;
    private double centerX;
    private double centerY;
    private double radius;
    private double innerHoleRadius;
    private double separatorLength;
    private Color holeColor = Color.web("#f4f4f4");
    private Color separatorColor = holeColor;

    public SemiCircleChart(List<Data> data){
        this(data, 0, 0,100);
    }

    public SemiCircleChart(List<Data> dataList, double centerX, double centerY, double radius){
        this(dataList,centerX,centerY,radius,0,0);
    }

    public SemiCircleChart(List<Data> dataList, double centerX, double centerY, double radius, double innerHoleRadius, double separatorLength){
        this.dataList = dataList;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.innerHoleRadius = innerHoleRadius;
        this.separatorLength = separatorLength;
        makeChart();
    }

    public void setHoleColor(Color holeColor){
        this.holeColor = holeColor;

        //reset the chart
        this.getChildren().clear();
        makeChart();
    }

    public void setSeparatorColor(Color separatorColor){
        this.separatorColor = separatorColor;

        //reset the chart
        this.getChildren().clear();
        makeChart();
    }
    private void makeChart(){
        double totalValues=0;

        for(Data data:dataList){
            totalValues += data.getValue();
        }

        double ratio = totalValues/180;
        double totalAngle=180;

        for(int i=0;i<dataList.size();i++){
            Data data = dataList.get(i);
            Arc slice = new Arc();
            slice.setCenterX(centerX);
            slice.setCenterY(centerY);
            slice.setRadiusX(radius);
            slice.setRadiusY(radius);
            slice.setType(ArcType.ROUND);
            slice.setFill(data.getColor());
            slice.setStartAngle(totalAngle);

            double length = data.getValue()/ratio;
            slice.setLength(-length);
            totalAngle -= length;

            //adding a tooltip
             Tooltip tooltip = new Tooltip(data.getName());


                slice.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        slice.setFill(data.getColor().brighter());
                        tooltip.show(slice, event.getScreenX()+10, event.getScreenY()+10);
                    }
                });

                slice.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        slice.setFill(data.getColor());
                        tooltip.hide();
                    }
                });
            this.getChildren().add(slice);

            if(separatorLength<0){
                throw new IllegalArgumentException("separatorLength can't be negative");
            }
            else if(separatorLength>0&&i<dataList.size()-1){
                Arc sep = new Arc();
                sep.setCenterX(centerX);
                sep.setCenterY(centerY);
                sep.setRadiusX(radius+1);//enough to cover the border of the slice
                sep.setRadiusY(radius+1);
                sep.setType(ArcType.ROUND);
                sep.setFill(separatorColor);
                sep.setLength(-separatorLength);
                //we calculate the start angle so half of the separator overlaps one slice and the other half the next slice.
                double halfLength = separatorLength/2;
                sep.setStartAngle(totalAngle+halfLength);
                this.getChildren().add(sep);
            }
        }

        if(innerHoleRadius<0){
            throw new IllegalArgumentException("innerHoleRadius can't be negative");
        }
        else{
            Arc hole = new Arc();
            hole.setCenterX(centerX);
            hole.setCenterY(centerY);
            hole.setRadiusX(innerHoleRadius);
            hole.setRadiusY(innerHoleRadius);
            hole.setType(ArcType.ROUND);
            hole.setFill(holeColor);
            hole.setStartAngle(0);
            hole.setLength(180);
            this.getChildren().add(hole);
        }
    }


    public static final class Data{
        private String name;
        private double value;
        private Color color;

        public Data(String name, double value) {
            this(name,value,Color.color(Math.random(), Math.random(), Math.random()));
        }

        public Data(String name, double value, Color color) {
            this.name = name;
            this.value = value;
            this.color = color;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public double getValue() {
            return value;
        }
        public void setValue(double value) {
            this.value = value;
        }
        public Color getColor() {
            return color;
        }
        public void setColor(Color color) {
            this.color = color;
        }

    }
}