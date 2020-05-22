public class APIModel {
    private int result;
    private String error_title;
    private String error_message;
    private ArrayList<String> type;
    private ArrayList<String> item_name;
    private ArrayList<String> file_name;
    private ArrayList<String> data;

    public APIModel() {
        result = -1;
        error_title = "";
        error_message = "";
        setType(new ArrayList<String>());
        setItem_name(new ArrayList<String>());
        setFile_name(new ArrayList<String>());
        setData(new ArrayList<String>());
    }

    public void populateModel(String type, String item_name, String file_name, String data) {
        this.type.add(type);
        this.item_name.add(item_name);
        this.file_name.add(file_name);
        this.data.add(data);
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getError_title() {
        return error_title;
    }

    public void setError_title(String error_title) {
        this.error_title = error_title;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public ArrayList<String> getItem_name() {
        return item_name;
    }

    public void setItem_name(ArrayList<String> item_name) {
        this.item_name = item_name;
    }

    public ArrayList<String> getFile_name() {
        return file_name;
    }

    public void setFile_name(ArrayList<String> file_name) {
        this.file_name = file_name;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }


}