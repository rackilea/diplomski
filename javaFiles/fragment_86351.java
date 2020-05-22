package spring.exos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

public static void main(String[] args){

    final Computer computer = new Computer();
    computer.setBrand("Toshiba");
    computer.setModel("TSB I7-SSD");
    computer.setSpecs(new Specs(new Integer(256), new Integer(8), new Double(2.4)));

    final ObjectMapper mapper = new ObjectMapper();
    try {
        System.out.println(mapper.writeValueAsString(computer));
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }

}

public static class Computer{
    private String brand;
    private String model;
    private Specs specs;

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Specs getSpecs() {
        return specs;
    }
    public void setSpecs(Specs specs) {
        this.specs = specs;
    }
}
public static class Specs {
    private Integer hdd;
    private Integer memory;
    private Double cpu;

    public Specs(Integer hdd, Integer memory, Double cpu) {
        super();
        this.hdd = hdd;
        this.memory = memory;
        this.cpu = cpu;
    }
    public Integer getHdd() {
        return hdd;
    }
    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }
    public Integer getMemory() {
        return this.memory;
    }
    public void setMemory(Integer memory) {
        this.memory = memory;
    }
    public Double getCpu() {
        return cpu;
    }
    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }
}
}