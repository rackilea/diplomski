static AdvanceTuning create(String string){
 if(Type.equalsIgnoreCase("Sharp")){

            return new SharpTuning();
        }
        else if(Type.equalsIgnoreCase("LowKey")){
return new LowKeyTuning();
        }
}