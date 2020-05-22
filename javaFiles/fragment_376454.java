import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by John on 7/11/2014.
 */
public class CircularText extends Pane {
    private double circleWidth;
    private double circleHeight;
    private double textSize;
    private double textStartDegree;
    private double textRotate;
    private double gapSpacing;
    private double offSetX;
    private double offSetY;
    private Font font;
    private Paint textFill;
    private String fontName;
    final String text;

    /** Default Constructor */
    public CircularText(String text) {
        this.circleWidth = 250;
        this.circleHeight = 250;
        this.text = text;
        textSize = (this.circleWidth / this.text.length()) * 2;
        this.font = new Font("Times Roman", textSize);
        this.textFill = Color.BLACK;
        this.textStartDegree = 240;
        this.textRotate = 90;
        this.gapSpacing = 0.975;
        this.offSetX = 4;
        this.offSetY = 3;
        paintText(this.text, this.font);
    }

    /** Create Constructor */
    public CircularText (String text, double w, double h) {
        this.circleWidth = w;
        this.circleHeight = h;
        this.text = text;
        textSize = (this.circleWidth / (this.text.length()) * 2);
        this.font = new Font("Times Roman", textSize);
        this.textFill = Color.BLACK;
        this.textStartDegree = 240;
        this.textRotate = 90;
        this.gapSpacing = 0.975;
        this.offSetX = 4;
        this.offSetY = 3;
        paintText(this.text, this.font);
    }

    /** Get font color */
    public Paint getTextFill() {
        return textFill;
    }

    /** Set font color */
    public void setTextFill(Paint textFill) {
        this.textFill = textFill;
        this.font = new Font(fontName, textSize);
        paintText(this.text, this.font);
    }

    /** Get starting position for text */
    public double getTextStartDegree() {
        return textStartDegree;
    }

    /** Set starting position for text */
    public void setTextStartDegree(double textStartDegree) {
        this.textStartDegree = textStartDegree;
        this.font = new Font(fontName, textSize);
        paintText(this.text, this.font);
    }

    /** Get letter rotation */
    public double getTextRotate() {
        return textRotate;
    }

    /** Set letter rotation */
    public void setTextRotate(double textRotate) {
        this.textRotate = textRotate;
        this.font = new Font(fontName, textSize);
        paintText(this.text, this.font);
    }

    /** Get spacing between ending and beginning of phrase */
    public double getGapSpacing() {
        return gapSpacing;
    }

    /** Set spacing between ending and beginning of phrase */
    public void setGapSpacing(double gapSpacing) {
        this.gapSpacing = gapSpacing;
        this.font = new Font(fontName, textSize);
        paintText(this.text, this.font);
    }

    /** Get current font */
    public Font getFont() {
        return this.font;
    }

    /** Set new font */
    public void setFont(String name) {
        this.font = new Font(name, textSize);
        this.fontName = name;
        paintText(this.text, this.font);
    }

    /** Return textSize */
    public double getTextSize() {
        return this.textSize;
    }

    /** Set textSize */
    public void setTextSize(double textSize, double offSetX, double offSetY) {
        this.textSize = textSize;
        this.offSetX = offSetX;
        this.offSetY = offSetY;
        this.font = new Font(fontName, textSize);
        paintText(this.text, this.font);
    }

    /** Return circle's width */
    public double getCircleWidth() {
        return circleWidth;
    }

    /** Set circle's width */
    public void setCircleWidth(double w) {
        this.circleWidth = w;
        textSize = (this.circleWidth / this.text.length()) * 2;
        paintText(this.text, this.font);
    }

    /** Return circle's height */
    public double getCircleHeight() {
        return circleHeight;
    }

    /** Set circle's height */
    public void setCircleHeight(double h) {
        this.circleHeight = h;
        textSize = (this.circleWidth / this.text.length()) * 2;
        paintText(this.text, this.font);
    }

    /** Paint the Letters */
    protected void paintText(String text, Font font) {
        getChildren().clear();
        // Initialize parameters
        double radius = Math.min(circleWidth, circleHeight) * 0.8 * 0.5;
        double centerX = circleWidth / 2;
        double centerY = circleHeight / 2;

        // Place text in a circular pattern
        int i = 0;
        double degree = 360.0 / (text.length() / this.gapSpacing);
        for (double degrees = this.textStartDegree;
             i < text.length(); i++, degrees += degree) {
            double pointX = centerX + radius *
                Math.cos(Math.toRadians(degrees)) - (this.textSize) *
                this.offSetX;
            double pointY = centerY + radius *
                Math.sin(Math.toRadians(degrees)) - (this.textSize) *
                this.offSetY;
            Text letter = new Text(pointX, pointY,
                String.valueOf(text.charAt(i)));
            letter.setFont(font);
            letter.setFill(this.textFill);
            letter.setRotate(degrees + this.textRotate);
            letter.setTextAlignment(TextAlignment.CENTER);
            getChildren().add(letter);
        }

    }
}