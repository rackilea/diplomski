void myArray(double a[], int size_a){
    double c = 4.0;
    a = &c;
    cout << *a;
}

int main(){
    double b[] = {1.0, 2.0, 3.0};
    myArray(b, 3);
    return 0;
}