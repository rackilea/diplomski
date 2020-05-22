double rMax = -1;
double previous = -1;
for(int i =1; i< 256; i++){
    for(int y =1; y< 256; y++){
        String x = image.getLocationAsString(i, y);
        String n = image.getValueAsString(i, y);

        String delim = ", value=";
        String [] tokens = n.split(delim);
        double num = Double.parseDouble(tokens[1]);

        String [] t = x.split("r=");
        String [] b = t[1].split(" mm/c");
        double radius = Double.parseDouble(b[0]);

        String [] theta = x.split("theta= ");
        String [] token2 = theta[1].split(Character.toString(IJ.degreeSymbol));
        float thetaNum = Float.parseFloat(token2[0]);

        if(radius > rMax){
            rMax = radius;
        }

        if(radius == previous){
            data[radius] += num;
        }
        else {
            data.Add(radius, num);
        }
     }
}
System.out.println(rMax);