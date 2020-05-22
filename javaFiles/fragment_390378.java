package org.jbox2d.gwtemul.org.jbox2d.common;

/**
 * A GWT-compatible implementation of the platform math utilities.
 */
class PlatformMathUtils {

  public static final float fastPow(float a, float b) {
    return (float) Math.pow(a, b);
  }
}