int main(void) {
        FILE *in;
        extern FILE *popen();
        char buff[512];
        char s[1024]; //someInput
        if(!(in = popen("java -jar EXEC.JAR --input " + s, "r"))){
            exit(1);
        }

        while(fgets(buff, sizeof(buff), in)!=NULL){
            printf("%s", buff);
        }
        pclose(in);
    }