// first derived class, automagically implemented by template magic
class MyGeneralComponent 
    : public ComponentImpl<MyGeneralComponent> 
{
     /* add new methods here */ 
};

// class further down in the hierarchy are also possible, 
// by using the second template argument. The implementation still works. 
class MySpecificComponent 
    : public ComponentImpl<MySpecificComponent,MyGeneralComponent> 
{
     /* add new methods here */ 
};