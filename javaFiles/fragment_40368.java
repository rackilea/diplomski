public abstract class Car{

private String licence;
private String color;

public static Car newCar(File file) throws FileNotFoundException {
    carType = null;
    Scanner in = new Scanner(file);

    while (in.hasNext()) {
        String line = in.nextLine();
        String tokens[] = line.split(";");

        if (line.contains("Light Weight")) {
            LightCar lightC = new LightCar(Long
                    .valueOf(tokens[1]).longValue(), tokens[3]);
            //Read here the color and the licence
            lightC.setColor(...);
            lightC.setLicence(...);
            //replace "..." by your value 
            in.close();
            carType = lightC;

        }
        if (line.contains("Heavy Weight")) {
            HeavyCar heavyC = new HeavyCar(Long.valueOf(
                    tokens[1]).longValue(), tokens[3]);
            //same as above
            in.close();
            carType = heavyC;
        }
    }
    in.close();
    return carType; 
    }


    public String getLicense(){
        return licence;
    }

    public void setLicence(String licence){
        this.licence=licence;
    }

    public String getCarColor(){
        return color;
    }

    public void setColor(String color){
        this.color=color;
    }
}