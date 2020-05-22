import com.google.gson.Gson;

public class JavaToJsonAndBack {

    public static void main(String[] args) {
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(albums));

    }
}

This is how the resulting JSON looks like

{"title":"Free Music Archive - Albums","message":"","errors":[],
"total":"11259","total_pages":2252,"page":1,"limit":"5"}