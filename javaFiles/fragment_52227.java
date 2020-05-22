Properties p = new Properties();

try (FileOutputStream stm = new FileOutputStream("nameOfFile"))
{
    p.store(stm, "Created by me.");     
} catch (IOException e) {
    // TODO: handle this
}