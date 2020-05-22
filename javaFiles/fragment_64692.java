public class superClass{

        private subclass subclassObj;

        public superClass() {
        }
        public superClass(subclass subclassObj) {
            this.subclassObj =  subclassObj;
        }

       public start(){
           //some code
       }

       public receive(){
           subclassObj.receive(); // call subclass' receive() method
       }