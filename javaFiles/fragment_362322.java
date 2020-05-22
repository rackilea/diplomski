package ${packageName};

public enum ${className} {

${body}

    private ${className}(String value){
        this.value = value;
    }

    private String value;

    public String getValue(){
        return this.value;
    }

}