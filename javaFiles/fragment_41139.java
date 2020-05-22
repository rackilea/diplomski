ifstream is;
is.open ("test.txt", ios::binary );
char* pBuffer = new char[4];

is.read (pBuffer, 4);
is.close();

int* pInt = reinterpret_cast<int*>(pBuffer);
int myInt = ntohl(*pInt); // This is only required if you are on a little endian box
delete [] pBuffer;