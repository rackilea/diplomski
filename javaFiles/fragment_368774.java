String result = null;

for(int i=0;i<root.length;i++){

    if(root[i][0].equals(hg)){
         result = root[i][1];
         break;
    }
}

System.out.println("result=" + result);