package domain.app.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 

    @ElementCollection
    @CollectionTable(name="STUDENT_HISTORY", joinColumns={@JoinColumn(name="STUDENT_ID", referencedColumnName="ID")})
    @Column(name="HISTORY")
    private Set<History> history = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<History> getHistory() {
        return history;
    }

    public void setHistory(Set<History> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", history=" + history + "]";
    }
}