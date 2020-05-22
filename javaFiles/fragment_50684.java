public static Kernel generateBlurKernel(int length, double std){
    Kernel out = new Kernel(length);

    int center = length/2;
    for(int i=0;i<length;i++){
        for(int j=0;j<length;j++){
            int x = Math.abs(j-center);
            int y = Math.abs(i-center);
            out.setValueAt(j, i, ((1d/(2*Math.PI*std*std))*Math.pow(Math.E, -((x*x)+(y*y))/(2*std*std))));
        }
    }
    out.normalize();
    return out;
}