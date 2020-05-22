org = new function() {//Define the structure one piece at a time
    this.antlr = new function(){
         this.namespace = ''; 
         return this;
    };
    return this;
};
org.antlr.namespace = function() {print('Help'); return 0;}