import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelExample {

        String title;

        public ModelExample(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
          List<ModelExample> model = new ArrayList<ModelExample>();
          model.add(new ModelExample("instructor"));
          model.add(new ModelExample("Dev"));
          model.add(new ModelExample("Dev 2"));
          model.add(new ModelExample("Dev 3"));
          model.add(new ModelExample("Dev 4"));
          model.add(new ModelExample("Dev 5"));
          model.add(new ModelExample("Dev 6"));


          for (int k = 0; k < model.size(); k++) {
              System.out.println("Title: " + model.get(k).getTitle());
          }

          System.out.println("\n\nSize of list before removing: " + model.size());

          for (int i = 0; i < model.size(); i++) {
              if (model.get(i).getTitle().equals("instructor")){
                  model.remove(i);
                  System.out.println("REMOVED INSTRUCTOR");
              }
          }

          System.out.println("Size of list after removing: " + model.size() + "\n\n");

          JSONArray array = new JSONArray();
          try {
              for (int i = 0; i < model.size(); i++) {
                  JSONObject object = new JSONObject();
                  object.put("title", model.get(i).getTitle());
                  array.put(object);
              }

              for (int j = 0; j < array.length(); j++) {
                  System.out.println("Title: " + array.get(j));
              }

              System.out.println(array.toString());
          } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
          }
    }

}