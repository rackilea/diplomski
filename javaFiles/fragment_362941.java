boolean osi = false;
boolean posi = false;
boolean tr = false;
boolean pta = false;
while((line=br.readLine())!=null){
    if(line.trim().isEmpty()) { 
        // end of record, print each of the 4 special Strings that didn't appear
        if(!osi){
            out.println("online_system_id");
        }
        if(!posi){
            out.println("proc_online_system_id");
        }    
        if(!tr){
            out.println("tran_reversed");
        }  
        if(!pta){
            out.println("prev_tran_approved");
        }
        osi = false;
        posi = false;
        tr = false;
        pta = false;  
    } else {
        // track appearance of the 4 special Strings
        if(line.contains("online_system_id")){
            osi = true;
        }
        if(line.contains("proc_online_system_id")){
            posi = true;
        }    
        if(line.contains("tran_reversed")){
            tr = true;
        }  
        if(line.contains("prev_tran_approved")){
            pta = true;
        }  
    }
    out.println(line);        //always print the current line
}