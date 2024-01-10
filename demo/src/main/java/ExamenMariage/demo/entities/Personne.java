package ExamenMariage.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CIN;
    private String prenom;
    @OneToMany(mappedBy = "PersonneEpoux")
    @JsonIgnore
    private List<Mariage> mariageEpoux=new ArrayList<>();
    @OneToMany(mappedBy = "PersonneEpouse")
    @JsonIgnore
    private List<Mariage> mariageEpouse=new ArrayList<>();

    public List<Mariage> getMariageEpoux() {
        return mariageEpoux;
    }

    public void setMariageEpoux(List<Mariage> mariageEpoux) {
        this.mariageEpoux = mariageEpoux;
    }

    public List<Mariage> getMariageEpouse() {
        return mariageEpouse;
    }

    public void setMariageEpouse(List<Mariage> mariageEpouse) {
        this.mariageEpouse = mariageEpouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Personne(String CIN, String prenom) {
        this.CIN = CIN;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", CIN='" + CIN + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
