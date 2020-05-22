for (String item : options){
    if(response.equals(item)){
        Class c;
        try {
            c = Class.forName(response);
            c.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}