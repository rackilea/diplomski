package com.bitplan.javafx;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.Observable;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

/**
 * We want a Pane that will automatically resize its components The components
 * width height and position are all expressed as a relative of the width and
 * height of the Pane from 0.0 to 1.0 As the Pane resizes the position and sizes
 * will all remain relative to the Pane's new width and height. Aspect ratio is
 * not respected
 * 
 * see https://gist.github.com/chriscamacho/4f8b2e3e8f8340278b7c
 * 
 * @author chriscamacho
 * @author wf - modified to relative instead of percent
 *
 */
public class RelativePane extends Pane implements RelativeSizer {
  protected static Logger LOGGER = Logger.getLogger("com.bitplan.javafx");
  public static boolean debug=false;

  /**
   * helper class to keep track of relative position
   */
  public class ControlBundle {
    public double rx, ry, rw, rh;
    public Control control;

    /**
     * construct me for the given control c and the given relative positions
     * 
     * @param c
     * @param rX
     * @param rY
     * @param rW
     * @param rH
     */
    ControlBundle(Control c, double rX, double rY, double rW, double rH) {
      control = c;
      rx = rX;
      ry = rY;
      rw = rW;
      rh = rH;
    }
  }

  Map<Control, ControlBundle> controls = new HashMap<Control, ControlBundle>();

  /**
   * create a relative Pane
   */
  public RelativePane() {
    super();
    widthProperty().addListener(o -> sizeListener(o));
    heightProperty().addListener(o -> sizeListener(o));
  }

  /**
   * show the bounds of the given node with the given title
   * 
   * @param title
   * @param b
   */
  public static void showBoundsPercent(String title, Bounds b) {
    LOGGER.log(Level.INFO,
        String.format("%s: min %.0f%%,%.0f%% max %.0f%%,%.0f%%", title,
            b.getMinX() * 100.0, b.getMinY() * 100.0, b.getMaxX() * 100.0,
            b.getMaxY() * 100.0));
  }

  /**
   * show the given bounds with the given title
   * 
   * @param title
   * @param b
   */
  public static void showBounds(String title, Bounds b) {
    LOGGER.log(Level.INFO, String.format("%s: min %.0f,%.0f max %.0f,%.0f",
        title, b.getMinX(), b.getMinY(), b.getMaxX(), b.getMaxY()));
  }


  /**
   * listen to a change of the given observable
   * @param o
   */
  void sizeListener(Observable o) {
    int index=0;
    for (ControlBundle cb : controls.values()) {
      index++;
      double w = getWidth() * cb.rw;
      double h = getHeight() * cb.rh;
      double x = getWidth() * cb.rx;
      double y = getHeight() * cb.ry;
      if (debug) {
        showBoundsPercent("r"+index,new BoundingBox(cb.rx,cb.ry,cb.rw,cb.rh));
        showBounds("a"+index,new BoundingBox(x,y,w,h));
      }

      cb.control.setPrefWidth(w);
      cb.control.setMinWidth(w);
      cb.control.setMaxWidth(w);

      cb.control.setPrefHeight(h);
      cb.control.setMinHeight(h);
      cb.control.setMaxHeight(h);

      cb.control.setLayoutX(x);
      cb.control.setLayoutY(y);

    }

  }

  /**
   * add a control with the given percentages
   * 
   * @param ctrl
   * @param x
   * @param y
   * @param w
   * @param h
   */
  public void addControl(Control ctrl, double x, double y, double w, double h) {
    this.getChildren().add(ctrl);
    controls.put(ctrl, new ControlBundle(ctrl, x, y, w, h));
  }

  public void removeControl(Control ctrl) {
    this.getChildren().remove(ctrl);
    controls.remove(ctrl);
  }

  @Override
  public Parent getSizer() {
    return this;
  }

}