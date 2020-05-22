import org.wiztools.xsdgen.XsdGen;
import java.io.File;
import java.io.FileOutputStream;

...

XsdGen gen = new XsdGen();
gen.parse(new File("in.xml"));
File out = new File("out.xsd");
gen.write(new FileOutputStream(out));