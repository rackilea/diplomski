package com.techtrip.test;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class GsonTest {

    private static Logger logger = LoggerFactory.getLogger(GsonTest.class);

    static ToSerialize t1 = new ToSerialize("1", "Test 1");
    static ToSerialize t2 = new ToSerialize("2", "Test 2");

    static ToSerialize target[] = {t1,t2} ;


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Gson gson = new Gson(); 

        String jsonStr = gson.toJson(target);

        logger.info(String.format("Target As String\n: %s", jsonStr));

        // This will work as well --> ToSerialize test[] = gson.fromJson(jsonStr, target.getClass());
        ToSerialize test[] = gson.fromJson(jsonStr, ToSerialize[].class);

        for (ToSerialize deserialized: test){
            logger.info(String.format("From JSON\n: %s", deserialized.toString()));
        }
    }

}

class ToSerialize implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    private String iD;
    private String name;


    public ToSerialize() {
        // TODO Auto-generated constructor stub
    }

    public ToSerialize(String iD, String name) {
        super();
        this.iD = iD;
        this.name = name;
    }

    public String getiD() {
        return iD;
    }
    public void setiD(String iD) {
        this.iD = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((iD == null) ? 0 : iD.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ToSerialize other = (ToSerialize) obj;
        if (iD == null) {
            if (other.iD != null)
                return false;
        } else if (!iD.equals(other.iD))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ToSerialize [iD=" + iD + ", name=" + name + "]";
    }
}