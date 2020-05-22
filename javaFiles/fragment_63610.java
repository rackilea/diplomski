char[] List={'a','b','c','d'};

int count=0;
for(int i=0;i<List.length;i++){
    for (int j=0;j<input.length();j++) {
        if(input.charAt(j)==List[i]){
            count++;
        }
    }
}
System.out.println(count);