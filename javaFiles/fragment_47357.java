public String getName(){
            if(this.getTurns()==1)
                name="X";
            else if(this.getTurns()==0)
                name="O";
            else
                name="-";
            return name;
        }