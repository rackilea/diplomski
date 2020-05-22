public class Profile
{
public string name;
public string surname;

public Profile getDatasForEdit()
{
return new Profile()
{
name = "Ritika",
surname = "Arora"
};
}
}

public class ProfileHelper{
    public void fillTheForm(Profile profileDatas)
    {
    formPageObject.nameField.sendKeys(dataModel.name);
    formPageObject.surnameField.sendKeys(dataModel.surname);
    }
}