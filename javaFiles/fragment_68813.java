package oodb;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "model", catalog = "oogvg", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")})
public class Model {
    private Integer ModelId;
    private String code;
    private String description;
    private Double cost;
    private Double price;  //selling price
    private Set<Article> articles= new HashSet<Article>(0); // lista di articoli

    public Model(){};

    public Model(String code, String description, Double cost, Double price) {
        super();
        this.code = code;
        this.description = description;
        this.cost = cost;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "model_id", unique = true, nullable = false)
    public Integer getModelId() {
        return ModelId;
    }

    public void setModelId(Integer modelId) {
        ModelId = modelId;
    }

    @Column(name = "code", unique = true, nullable = false, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "model_article", catalog = "oogvg", joinColumns = {
            @JoinColumn(name = "model_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "article_id",
                    nullable = false, updatable = false) })
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Model [ModelId=" + ModelId + ", code=" + code + ", description=" + description + ", cost=" + cost
                + ", price=" + price + "]";
    }




}