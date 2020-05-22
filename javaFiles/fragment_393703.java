import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ParseJson {

    public static void main(String a[]) {
        Gson g = new Gson();
        try {
            Employee e = g.fromJson(new JsonReader(new FileReader("file.json")), Employee.class);

            parseEmployees(e);
            printEmployee(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    private static void parseEmployees(Employee e) {
        setParentAndLevel(e, 1, null);
    }

    private static void setParentAndLevel(Employee e, int lvl, String parent) {
        e.level = lvl;
        e.parentName = parent;
        if (e.children != null && e.children.length > 0) {
            lvl++;
            for (Employee emp : e.children) {
                setParentAndLevel(emp, lvl, e.name);
            }
        }
    }

    public static void printEmployee(Employee e){
        System.out.println(e);
        if (e.children != null && e.children.length > 0) {
            for (Employee emp : e.children) {
                printEmployee(emp);
            }
        }else{
            return ;
            }
        }
    }

    class Employee {
        String name;
        String title;
        Employee children[];
        int level;
        String parentName;

        @Override
        public String toString() {
            return "{name =  " + name + " , parent = " + parentName + ", level = " + level + " }";
        }
    }