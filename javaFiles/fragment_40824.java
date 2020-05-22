int queryRoom = 37;
queryRoom--; // create 0-based index

int a = queryRoom / 15;
int b = queryRoom % 15;

int floorInQuestion = (a * 2);
if(b < 5) floorInQuestion++;
else floorInQuestion += 2;