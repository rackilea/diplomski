import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

class Course {

    public int _id;
    public String _name;
    public Teacher _teacher;

    private Course(int id, String name, Teacher teacher){
        this._id = id;
        this._name = name;
        this._teacher = teacher;
    }
    public Course() {

    }
}

class Teacher {
    public int _id;
    public String _firstName;
    public String _lastName;
    private Teacher(int id, String fname, String lname){
        this._id = id;
        this._firstName = fname;
        this._lastName = lname;
    }
    public Teacher(){

    }

}

public class jsontest {

    public static void main(String[] args) throws JSONException, IOException {

//        String JSON_DATA = "{\n"+
//        " \"courses\": [\n"+
//        " { \"id\":\"998\", \"name\":\"Java Data Structures\", \"teacherId\":\"375\" },\n"+
//        " { \"id\":\"999\", \"name\":\"Java Generics\", \"teacherId\":\"376\" }\n"+
//        "\n"+
//        " ],\n"+
//        " \"teachers\": [\n"+
//        " { \"id\":\"375\", \"firstName\":\"Amiyo\", \"lastName\":\"Bagchi\"},\n"+
//        " { \"id\":\"376\", \"firstName\":\"Dennis\", \"lastName\":\"Ritchie\"} \n"+
//        " ]\n"+
//        "}\n"+
//        "";
        // read json file into string
        String JSON_DATA = new String(Files.readAllBytes(Paths.get("path_to_json_file")), StandardCharsets.UTF_8);

        // using a JSON parser
        JSONObject obj = new JSONObject(JSON_DATA);
        // parse "teachers" first
        List<Teacher> listCourses = new ArrayList<Teacher>();
        List<JSONObject> listObjs = parseJsonData(obj,"teachers");
        for (JSONObject c: listObjs) {
            Teacher teacher = new Teacher();
            teacher._id = c.getInt("id");
            teacher._firstName = c.getString("firstName");
            teacher._lastName = c.getString("lastName");
            listCourses.add(teacher);
        }
        // parse "courses" next
        List<Course> resultCourses = new ArrayList<Course>();
        List<JSONObject> listObjs2 = parseJsonData(obj, "courses");

        for (JSONObject c: listObjs2) {
            Course course = new Course();
            course._id = c.getInt("id");
            course._name = c.getString("name");
            int teacherId =  c.getInt("teacherId");
            HashMap<String, Teacher> map = new HashMap<String, Teacher>();
            for (Teacher t: listCourses){
                map.put(Integer.toString(t._id), t);
            }
            course._teacher = map.get(Integer.toString(teacherId));
            resultCourses.add(course);
        }
    }


    public static List<JSONObject> parseJsonData(JSONObject obj, String pattern)throws JSONException {

        List<JSONObject> listObjs = new ArrayList<JSONObject>();
        JSONArray geodata = obj.getJSONArray (pattern);
        for (int i = 0; i < geodata.length(); ++i) {
          final JSONObject site = geodata.getJSONObject(i);
          listObjs.add(site);
        }
        return listObjs;
    }

}