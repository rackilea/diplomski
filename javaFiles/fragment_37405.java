void search(int arr[], int left, int right, int x) {
  if (left > right)
    cout << "Element " << x << " been not found!\n;
  else
    if (tab[left] == x)
      cout << "Element " << x << "been found at position " << left << "\n";
    else
      search(tab, left+1, right, x); // call search() witch updated properties
}