package de.mosst.spielwiese;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import lombok.Data;

public class XStreamDeserializeJsonWithJettison {

    @Test
    @SuppressWarnings("unchecked")
    public void smokeTest() {
        InputStream file = XStreamDeserializeJsonWithJettison.class.getResourceAsStream("XStreamDeserializeJsonWithJettison.json");
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.processAnnotations(Entity.class);

        List<Entity> entities = (List<Entity>) xStream.fromXML(file);
        System.out.println(entities);
    }

    @Data
    @lombok.AllArgsConstructor
    @XStreamAlias("entity")
    class Entity {
        String id;
        String name;
    }
}