class ModelLayer
{
    public void ModelLayer()
    {
        this.age = 1;
    }

    public int getAgeFromDb()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

class View
{
     public void View(ModelLayer modelLayer)
     {
          this.modelLayer = modelLayer;
     }

     public string render()
     {
         return this.modelLayer.getAgeFromDb();
     }
}

class Controller
{
     public void Controller(ModelLayer modelLayer)
     {
          this.modelLayer = modelLayer;
     }

     public void onSaveBtnClick()
     {
          this.modelLayer.setAge(2);
     }
}