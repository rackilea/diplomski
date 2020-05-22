public boolean isEmpty(ViewGroup viewGroup){

            for(int i=0;i<viewGroup.getChildCount();i++){
                View view = viewGroup.getChildAt(i);
                if(view instanceof ViewGroup){
                    boolean isEmpty= isEmpty((ViewGroup) view);

                    if(isEmpty){
                        return true;
                    }
                }else if(view instanceof EditText){
                    EditText editText= (EditText) view;
                    String input = editText.getText().toString();

                    if("".equals(input)){
                        return true;
                    }
                }
            }

         return false;
    }