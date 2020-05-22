List<string> array1 = new List<string>();
array1.Add("test");

List<List<string>> array2 = new List<List<string>>();
array2.Add(array1);

string myStr = array2[0][0]; //Whatever indexers you want here