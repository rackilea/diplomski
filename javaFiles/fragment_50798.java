@JsonIgnorePropertires("ignoreUnknown = true")
    class User(){
        String departName;

        @JsonProperty("department")
        private void mapDepartmentName(Map<String,Object department) {
            this.departName = ((Map<String,String>)department.get("departInfo")).get("departName");
        }
    }