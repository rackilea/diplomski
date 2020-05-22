package kpi.ua.shapes;

public class Complex extends Point {

    private Double re;
    private Double im;

    public Complex(Double im, Double re) {
        this.im = im;
        this.re = re;
        Double r = Math.sqrt(im * im + re * re);
        Double fi = Math.atan(im / re);
        this.x=r * Math.cos(fi);
        this.y=r * Math.sin(fi);
    }

    public Double getRe() {
        return re;
    }

    public void setRe(Double re) {
        this.re = re;
    }

    public Double getIm() {
        return im;
    }

    public void setIm(Double im) {
        this.im = im;
    }

}