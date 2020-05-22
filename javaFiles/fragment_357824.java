class Test
{
int a;
Test obj1;
Test obj2;
Test()
{
a=10;
}
void tester()
{
    obj1=new Test();
    obj2=new Test();
    obj1.a=20;
    obj2.a=30;
}
void test(Test obj3,Test obj4)
{
tester();
obj3=obj1;
obj4=obj2;
}
}