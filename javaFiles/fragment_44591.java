String str = "Test";
int num = 10;
int array[] = {1,2,3};
Intent intent = new Intent(FirstPage.this, SecondPage.class);
intent.putExtra("TEST_STRING", str);
intent.putExtra("TEST_INT", num);
intent.putExtra("TEST_INT_ARRAY", array);
startActivity(intent);