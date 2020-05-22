public MyString[] split(char c){
        StringBuilder builder = new StringBuilder();
        ArrayList<MyString> myStringList = new ArrayList<>();
        for(int i = 0; i < characterSequence.length; i++){
            if(characterSequence[i] != c){
                builder.append(characterSequence[i]);
            }
            else{
                if(builder.length() != 0){
                    myStringList.add(new MyString(builder.toString()));
                    builder = new StringBuilder();
                }
            }
        }
        if(builder.length() != 0){
            myStringList.add(new MyString(builder.toString()));
        }
        return myStringList.toArray(new MyString[]{});
    }