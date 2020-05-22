interface ICollaboratorTextLocator {
    String getCollaboratorText();
}

class ConstantCollaboratorTextLocator implements ICollaboratorTextLocator {
    String text;

    ConstantCollaboratorTextLocator(String text) {
        this.text = text;
    }
}

class SuperClass {
    Collaborator collaborator;

    public setCollaboratorTextLocator(ICollaboratorTextLocator locator) {
        collaborator = new Collaborator(locator.getCollaboratorText());
    }

    SuperClass() {
       setCollaboratorTextLocator(new ConstantCollaboratorTextLocator("whatever"));
    }
}

class SubClass {
    String text = "something";

    SubClass() {
        setCollaboratorTextLocator(new ConstantCollaboratorTextLocator(text));
    }
}