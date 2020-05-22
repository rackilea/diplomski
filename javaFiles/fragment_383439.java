public ArrayList<Actor> generateImageActor(){
        ArrayList<Actor> temp = new ArrayList<Actor>();
        Image img = new Image(____);
        for(int i = 0; i <10; i++){
            MyActor act = new MyActor(img);
            temp.add(act);
        }
        return temp;
    }