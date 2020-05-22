public class MyAction implements Serializable{
        ....
        public void prepareNextState(FormBean formBean){
            //displayNextState is a String field in FormBean                
            formBean.setDisplayNextState("someView");
        }
        ....
    }