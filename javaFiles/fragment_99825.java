private class MenuFieldHolder {
    @SerializedName("menu_fields") 
    private MenuField[] menuFields;
}

private class MenuField {
    private int id;

    @SerializedName("menu_id") 
    private int menuId;

    @SerializedName("field_type") 
    private int fieldType;

    @SerializedName("c4w_code") 
    private String c4wCode;

    @SerializedName("field_label") 
    private String fieldLabel;

    @SerializedName("field_values") 
    private String fieldValues;

    @SerializedName("date_created") 
    private String dateCreated;

    @SerializedName("date_modified") 
    private String dateModified;

    @SerializedName("is_required") 
    private int isRequired;

    @SerializedName("is_static") 
    private int isStatic;

    @SerializedName("field_order") 
    private String fieldOrder;
}