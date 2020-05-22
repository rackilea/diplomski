int main() {
    long a[10] = {1,2,3,4,15,5,11,12,13,14}; // two sorted halves to merge
    long * temp = new long[10];
    for (int i = 0; i < 10; i++)
    {
        cout << a[i] << ","; // printout before merge
    }
    cout << endl;
    merge(a, temp, 0, 5, 9); // 0-4 and 5-9
    for (int i = 0; i < 10; i++)
    {
        cout << a[i] << ","; // printout after merge
    }
}