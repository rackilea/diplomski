import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HighlightingLabelLayout extends Pane {

    private static final PseudoClass HIGHLIGHTED = PseudoClass.getPseudoClass("highlighted");

    private boolean needsRebuild = true ;

    private final Label ellipsis = new Label("...");

    private final StringProperty text = new StringPropertyBase() {

        @Override
        public String getName() {
            return "text" ;
        }

        @Override
        public Object getBean() {
            return HighlightingLabelLayout.this ;
        }

        @Override
        protected void invalidated() {
            super.invalidated();
            needsRebuild = true ;
            requestLayout();
        }
    };

    private final StringProperty highlightText = new StringPropertyBase() {

        @Override
        public String getName() {
            return "highlightText" ;
        }

        @Override
        public Object getBean() {
            return HighlightingLabelLayout.this ;
        }

        @Override
        protected void invalidated() {
            super.invalidated();
            needsRebuild = true ;
            requestLayout();
        }
    };

    public final StringProperty textProperty() {
        return this.text;
    }


    public final String getText() {
        return this.textProperty().get();
    }


    public final void setText(final String text) {
        this.textProperty().set(text);
    }


    public final StringProperty highlightTextProperty() {
        return this.highlightText;
    }


    public final String getHighlightText() {
        return this.highlightTextProperty().get();
    }


    public final void setHighlightText(final String highlightText) {
        this.highlightTextProperty().set(highlightText);
    }

    public HighlightingLabelLayout() {
        ellipsis.getStyleClass().add("ellipsis");
        getStylesheets().add(getClass().getResource("highlighting-label-layout.css").toExternalForm());
    }

    @Override
    protected void layoutChildren() {
        if (needsRebuild) {
            rebuild() ;
        }
        double width = getWidth();
        double x = snappedLeftInset() ;
        double y = snappedTopInset() ;
        boolean truncated = false ;
        for (Node label : getChildren()) {
            double labelWidth = label.prefWidth(-1);
            double labelHeight = label.prefHeight(labelWidth);
            if (label == ellipsis) {
                label.resizeRelocate(width - labelWidth - snappedRightInset(), y, labelWidth, labelHeight);
                continue ;
            }
            if (truncated) {
                label.setVisible(false);
                continue ;
            }
            if (labelWidth + x > width - snappedLeftInset() - snappedRightInset()) {
                label.resizeRelocate(x, y, width - snappedLeftInset() - snappedRightInset() - x, labelHeight);
                truncated = true ;
                label.setVisible(true);
                x = width - snappedRightInset();
                continue ;
            }
            label.resizeRelocate(x, y, labelWidth, labelHeight);
            x+=labelWidth ;
        }
        ellipsis.setVisible(truncated);
    }

    @Override
    protected double computePrefWidth(double height) {
        if (needsRebuild) {
            rebuild();
        }
        double width = 0 ;
        for (Node label : getChildren()) {
            if (label != ellipsis) {
                width += label.prefWidth(height);
            }
        }
        return width ;
    }

    @Override
    protected double computeMaxWidth(double height) {
        return computePrefWidth(height);
    }

    @Override
    protected double computeMinWidth(double height) {
        return Math.min(ellipsis.minWidth(height), computePrefWidth(height));
    }

    @Override
    protected double computePrefHeight(double width) {
        if (needsRebuild) {
            rebuild();
        }
        double height = 0 ;
        for (Node label : getChildren()) {
            if (label != ellipsis) {
                double labelWidth = label.prefWidth(-1);
                double labelHeight = label.prefHeight(labelWidth);
                if (labelHeight > height) {
                    height = labelHeight ;
                }
            }
        }
        return height ;
    }

    @Override
    protected double computeMinHeight(double width) {
        return Math.min(computePrefHeight(width), ellipsis.prefHeight(ellipsis.prefWidth(-1)));
    }

    @Override
    protected double computeMaxHeight(double width) {
        return computePrefHeight(width);
    }

    // Performance could probably be improved by caching and reusing the labels...
    private void rebuild() {
        String[] words = text.get().split("\\s");
        String highlight = highlightText.get();
        getChildren().clear();
        StringBuffer buffer = new StringBuffer();
        boolean addLeadingSpace = false ;
        for (int i = 0 ; i < words.length ; i++) {
            if (words[i].equals(highlight)) {
                if ( i > 0) {
                    getChildren().add(new Label(buffer.toString()));
                    buffer.setLength(0);
                }
                Label label = new Label(words[i]);
                label.pseudoClassStateChanged(HIGHLIGHTED, true);
                addLeadingSpace = true ;
                getChildren().add(label);
            } else {
                if (addLeadingSpace) {
                    buffer.append(' ');
                }
                buffer.append(words[i]);
                if (i < words.length - 1) {
                    buffer.append(' ');
                }
                addLeadingSpace = false ;
            }
        }
        if (buffer.length() > 0) {
            getChildren().add(new Label(buffer.toString()));
        }
        getChildren().add(ellipsis);

        needsRebuild = false ;
    }

}