public virtual void BeforeFoo(){}

public void Foo()
{

this.BeforeFoo();
//do some stuff
this.AfterFoo();

}

public virtual void AfterFoo(){}