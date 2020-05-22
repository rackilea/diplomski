package models;

import javax.persistence.*;

import com.avaje.ebean.Model;

@Entity
public class Task extends Model {

    @Id
    public Long id;

    ...
}