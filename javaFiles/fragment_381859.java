public class Parent {

    private Image image;

    public void setImage(Image image) {
      if ("medium".equals(image.getSize())) {
        this.image = image;
      }
    }

  }

  public class Image {

    private String size;
    private String url;
  }

  public static void main(String[] args) throws IOException, SAXException {
    String s = "<parent>" 
        + "<image size='small'>some url1</image>"
        + "<image size='medium'>some url2</image>"
        + "<image size='large'>some url3</image>"
        + "<image size='huge'>some url4</image>"
        + "</parent>";

    Digester digester = new Digester();

    digester.addObjectCreate("parent", Parent.class);
    digester.addFactoryCreate("parent/image", new ImageCreationFactory());
    digester.addBeanPropertySetter("parent/image", "url");
    digester.addSetNext("parent/image", "setImage");
    Parent p = (Parent) digester.parse(new StringReader(s));
  }

  public class ImageCreationFactory implements ObjectCreationFactory {

    public Object createObject(Attributes attributes) throws Exception {
      Image i = new Image();
      i.setSize(attributes.getValue("size"));
      return i;
    }

  }