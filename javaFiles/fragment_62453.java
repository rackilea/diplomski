public void load() {
    FileInputStream filein = new FileInputStream("data");
    ObjectInputStream in = new ObjectInputStream(filein);
    Model model = (Model) in.readObject();
    in.close();
}

public void save() {
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data"));
    out.writeObject(model);
    out.close();
}