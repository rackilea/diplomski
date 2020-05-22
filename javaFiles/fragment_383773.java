import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import my.test.XmlOut.TaskId;
import my.test.XmlOut.TaskListAdapter;
import my.test.XmlOut.File.Details;
import my.test.XmlOut.File.Task;
import my.test.XmlOut.File.TaskList;

public class XmlOut {
public static class TaskId {

}

public static class TaskListAdapter extends XmlAdapter<String,TaskId> {

    @Override
    public TaskId unmarshal(String v) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String marshal(TaskId v) throws Exception {
        //Load your actual TASK here and convert it to XML (you could use JAXB as well)
        return "HERE GOES MY TASK XML";
    }

}

@XmlRootElement
public static class File {

    public static class TaskList {
        int fileid;

    }

    public static class Task {
        String id;

        @XmlElement
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Details {
        String d1;
        String dn;
        private List<Task> tasks;
        private List<TaskId> taskIds;

        public void setTasks(List<Task> t) {
            tasks = t;
        }

        @XmlElement
        public String getD1() {
            return d1;
        }

        public void setD1(String d1) {
            this.d1 = d1;
        }

        @XmlElement
        public String getDn() {
            return dn;
        }

        public void setDn(String dn) {
            this.dn = dn;
        }

        @XmlElement(name="task") 
        @XmlJavaTypeAdapter(TaskListAdapter.class)
        public List<TaskId> getTaskIds() {
            return taskIds;
        }

        public void setTaskIds(List<TaskId> asList) {
            taskIds = asList;
        }



    }

    protected Details details = new Details();

    @XmlElement
    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}

public static void main(String[] args) {
    try {

        File file = new File();
        file.setDetails(new Details());
        file.getDetails().setD1("d1");
        file.getDetails().setTaskIds(Arrays.asList(new TaskId(), new TaskId(), new TaskId(), new TaskId(), 
                new TaskId(), new TaskId(), new TaskId()));
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        JAXBContext jc = JAXBContext.newInstance(File.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

        JAXBElement<File> jx = new JAXBElement<>(new QName("http://namespace", "File"), File.class, file);          
        m.marshal(jx, System.out);          
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}