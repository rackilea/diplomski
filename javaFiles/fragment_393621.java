package com.example;

import java.awt.Image;
import javax.activation.DataHandler;
import javax.xml.bind.annotation.*;
import javax.xml.transform.Source;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "_default",
    "imageGif",
    "imageJpeg",
    "textXml",
    "applicationXml",
    "anythingElse"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(name = "default")
    protected byte[] _default;
    @XmlMimeType("image/gif")
    protected Image imageGif;
    @XmlMimeType("image/jpeg")
    protected Image imageJpeg;
    @XmlMimeType("text/xml")
    protected Source textXml;
    @XmlMimeType("application/xml")
    protected Source applicationXml;
    @XmlMimeType("anything/else")
    protected DataHandler anythingElse;


    ...
}