import com.google.gson.Gson;

import java.util.List;


public class TestMe {

    public static void main(String[] args) {

        String jsonSt2 = "{\"model\":[{\"syscall_1\":\"execve\",\"syscall_2\":\"brk\"},{\"syscall_1\":\"brk\",\"syscall_2\":\"access\"},{\"syscall_1\":\"access\",\"syscall_2\":\"mmap\"},{\"syscall_1\":\"mmap\",\"syscall_2\":\"access\"}]}";
        System.out.println("your json: " + jsonSt2);

        ModelObject object = new Gson().fromJson(jsonSt2, ModelObject.class);

        System.out.println("Created Model object, array size is " + object.model.size());

        for (ModelItem mi : object.model) {
            System.out.println(mi.syscall_1 + " " + mi.syscall_2);
        }
    }
}

class ModelObject {
    List<ModelItem> model;
}

class ModelItem {
    String syscall_1;
    String syscall_2;
}