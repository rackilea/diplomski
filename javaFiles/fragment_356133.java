public String shiftWord(String s,int length){
        String d;
        Log.d("find", "proper" + "" + "shiftWord");
        char[] c=s.toCharArray();           
        for(int i=0;i<c.length;i++){
                if(c[i]=='a')
                    c[i]='z';
                else if(c[i]=='b')
                    c[i]='a';
                else if(c[i]=='c')
                    c[i]='b';
                else if(c[i]=='d')
                    c[i]='c';
                else if(c[i]=='e')
                    c[i]='d';
                else if(c[i]=='f')
                    c[i]='e';
                else if(c[i]=='g')
                    c[i]='f';
                else if(c[i]=='h')
                    c[i]='g';
                else if(c[i]=='i')
                    c[i]='h';
                else if(c[i]=='j')
                    c[i]='i';
                else if(c[i]=='k')
                    c[i]='j';
                else if(c[i]=='l')
                    c[i]='k';
                else if(c[i]=='m')
                    c[i]='l';
                else if(c[i]=='n')
                    c[i]='m';
                else if(c[i]=='o')
                    c[i]='n';
                else if(c[i]=='p')
                    c[i]='o';
                else if(c[i]=='q')
                    c[i]='p';
                else if(c[i]=='r')
                    c[i]='q';
                else if(c[i]=='s')
                    c[i]='r';
                else if(c[i]=='t')
                    c[i]='s';
                else if(c[i]=='u')
                    c[i]='t';
                else if(c[i]=='v')
                    c[i]='u';
                else if(c[i]=='w')
                    c[i]='v';
                else if(c[i]=='x')
                    c[i]='w';
                else if(c[i]=='y')
                    c[i]='x';
                else if(c[i]=='z')
                    c[i]='y';
            }
        }
        d = new String(c);
        return d;       
    }