package com.example;

import org.springframework.data.annotation.Id;

public class Tag
{
    @Id
    String id;
    String tag;

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getTag()
    {
        return tag;
    }
    public void setTag(String tag)
    {
        this.tag = tag;
    }
}