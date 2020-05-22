package models;

import java.util.List;

import javax.persistence.Entity;

import play.db.*;
import play.db.ebean.Model;

import play.api.db.DB;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;


@Entity

public class Product extends Model{

    public int id;
    public String name;
    public String description;

    public static Model.Finder<String, Product> find = new Model.Finder<String, Product>(String.class, Product.class);

    public Product(){

    }

    public Product(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static  List<Product> findAll(){
        return  Product.find.orderBy("id").findList();
    }
}