int foo(String s){  
    int total = 0;
    String currentNum = ""  
    for(int i =0;i<s.length;i++){   
        if(s[i] =="+"){   
           total += Integer.parseInt(currentNum);   
           currentNum = ""   
        }else if(s[i] =="-"){  
           total -= Integer.parseInt(currentNum);  
           currentNum = ""  
        }else{   
           currentNum += s[i]   
        }   
     }     
     return total;
}