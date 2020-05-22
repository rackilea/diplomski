class Root {
    Response response;
}

class Response {
    @SerializedName("70")
    List<Integer> listA;

    @SerializedName("75")
    List<Integer> listB;
}