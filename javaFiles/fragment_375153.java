int initToZero1;
static float initToZero2;
FILE * initToZero3; 
// all are stored in initialized to zero segment(BSS)

double intitialized1 = 20.0;
// stored in initialized data segment

int main()
{
    size_t (*fp)(const char *) = strlen;
    // fp is an auto variable that is allocated in stack
    // but it points to code area where code of strlen() is stored

    char *dynamic = (char *)malloc(100);
    // dynamic memory allocation, done in heap

    int stringLength;
    // this is an auto variable that is allocated in stack

    static int initToZero4; 
    // stored in BSS

    static int initialized2 = 10; 
    // stored in initialized data segment   

    strcpy(dynamic,”something”);    
    // function call, uses stack

    stringLength = fp(dynamic); 
    // again a function call 
}