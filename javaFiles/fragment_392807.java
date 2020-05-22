public class MyPresenter {
     private MyPresenterIView iViewInstance;

        public MyPresenter(MyPresenterIView iView){
          this.iViewInstance=iView;
        }

        public void onSubmitClick(){
          //write your logic here
         String fieldOneText=iViewInstance.getFieldOneText();
         sendToServer(fieldOneText);
        }

        private void sendToServer(String stringInfo){
        //send info to server
        }

    }