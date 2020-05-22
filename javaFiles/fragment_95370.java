package ga;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class FileReader {

    private int numCities;
    private double mutationRate;
    private City[] cities;
    private int curLine;
    private StringTokenizer st;
    private int arrayCount;
    private int x, y;
    private double crossoverRate;
    private String fileName;

    public FileReader(String fileName) {
        numCities = 0;
        mutationRate = 0;
        City[] cities = new City[0];
        curLine = 1;
        arrayCount = 0;        
        this.fileName=fileName;
        read();
    }

    public int getNumCities() {
        return numCities;
    }

    public void setNumCities(int numCities) {
        this.numCities = numCities;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public int getCurLine() {
        return curLine;
    }

    public void setCurLine(int curLine) {
        this.curLine = curLine;
    }

    public StringTokenizer getSt() {
        return st;
    }

    public void setSt(StringTokenizer st) {
        this.st = st;
    }

    public int getArrayCount() {
        return arrayCount;
    }

    public void setArrayCount(int arrayCount) {
        this.arrayCount = arrayCount;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void read() {

        try {
            BufferedReader in = new BufferedReader(new java.io.FileReader("./"+fileName));
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    if (curLine == 1) {
                        st = new StringTokenizer(line, "=");
                        st.nextToken();
                        numCities = Integer.parseInt(st.nextToken());
                        cities = new City[numCities];
                    } else if (curLine == 2) {
                        st = new StringTokenizer(line, "=");
                        st.nextToken();
                        mutationRate = Double.parseDouble(st.nextToken());
                    }else if(curLine==3){
                        st = new StringTokenizer(line, "=");
                        st.nextToken();
                       crossoverRate = Double.parseDouble(st.nextToken());
                    }
                    else {
                        st = new StringTokenizer(line, "|");
                        st.nextToken();
                        String a = st.nextToken();
                        StringTokenizer stmp = new StringTokenizer(a, "=");
                        stmp.nextToken();
                        x = Integer.parseInt(stmp.nextToken());
                        String l = st.nextToken();
                        stmp = new StringTokenizer(l, "=");
                        stmp.nextToken();
                        y = Integer.parseInt(stmp.nextToken());

                        cities[arrayCount] = new City(arrayCount, x, y);
                        arrayCount++;
                    }
                    curLine++;

                }
            } catch (Exception e) {
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }
}