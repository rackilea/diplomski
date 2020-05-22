int main( void ){
        int i, j;
        for (i=0;i<100000;i++){
                for (j=0;j<100000;j++){
                        continue;
                }
        }
        return 0;
}