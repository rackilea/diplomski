package yourpackage;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[]args) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        String xml = new String(Files.readAllBytes(Paths.get("test.xml")));
        Testrun value = xmlMapper.readValue(xml, Testrun.class);

        for(Test t : value.getTest()) System.out.println(t.getOutput());
    }
}

class Test
{
    private String duration;
    private String locationUrl;
    private String status;
    private String name;
    private Output output;

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getLocationUrl ()
    {
        return locationUrl;
    }

    public void setLocationUrl (String locationUrl)
    {
        this.locationUrl = locationUrl;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Output getOutput ()
    {
        return output;
    }

    public void setOutput (Output output)
    {
        this.output = output;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [duration = "+duration+", locationUrl = "+locationUrl+", status = "+status+", name = "+name+", output = "+output+"]";
    }
}


class Output
{
    @JacksonXmlText
    private String content;
    @JacksonXmlProperty(localName = "type")
    private String type;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", type = "+type+"]";
    }
}


class Count
{
    private String name;

    private String value;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", value = "+value+"]";
    }
}

class Root
{
    private String location;

    private String name;

    private Output output;

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Output getOutput ()
    {
        return output;
    }

    public void setOutput (Output output)
    {
        this.output = output;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [location = "+location+", name = "+name+", output = "+output+"]";
    }
}


class Module
{
    private String name;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+"]";
    }
}

class Option
{
    private String name;

    private String value;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", value = "+value+"]";
    }
}

class Config
{
    private Module module;

    private String name;

    private String nameIsGenerated;

    private Option[] option;

    private String configId;

    public Module getModule ()
    {
        return module;
    }

    public void setModule (Module module)
    {
        this.module = module;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getNameIsGenerated ()
    {
        return nameIsGenerated;
    }

    public void setNameIsGenerated (String nameIsGenerated)
    {
        this.nameIsGenerated = nameIsGenerated;
    }

    public Option[] getOption ()
    {
        return option;
    }

    public void setOption (Option[] option)
    {
        this.option = option;
    }

    public String getConfigId ()
    {
        return configId;
    }

    public void setConfigId (String configId)
    {
        this.configId = configId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [module = "+module+", name = "+name+", nameIsGenerated = "+nameIsGenerated+", option = "+option+", configId = "+configId+"]";
    }
}

class Testrun
{
    private String duration;

    private String footerText;

    private Count[] count;

    private Root root;

    @JacksonXmlElementWrapper(useWrapping=false, localName = "test")
    private Test[] test;

    private String name;

    private Config config;

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getFooterText ()
    {
        return footerText;
    }

    public void setFooterText (String footerText)
    {
        this.footerText = footerText;
    }

    public Count[] getCount ()
    {
        return count;
    }

    public void setCount (Count[] count)
    {
        this.count = count;
    }

    public Root getRoot ()
    {
        return root;
    }

    public void setRoot (Root root)
    {
        this.root = root;
    }

    public Test[] getTest ()
    {
        return test;
    }

    public void setTest (Test[] test)
    {
        this.test = test;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Config getConfig ()
    {
        return config;
    }

    public void setConfig (Config config)
    {
        this.config = config;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [duration = "+duration+", footerText = "+footerText+", count = "+count+", root = "+root+", test = "+test+", name = "+name+", config = "+config+"]";
    }
}