package com.mycorp.myapp.model;
import java.util.*;
import com.google.gson.annotations.*;

public class Category {

    public Category(){
        SubCategories = new ArrayList<Category>();
    }

    public int Id;

    public String Name;

    public int ParentId;

    //@Expose(serialize = false, deserialize = false)
    transient List<Category> SubCategories;
}