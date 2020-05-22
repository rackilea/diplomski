package com.stackoverflow.test.xstream_xml_to_map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Response")
public class Response {

private String Status = new String();

private String Credit = new String();

public String getStatus() {
    return Status;
}

public String getCredit() {
    return Credit;
}
}