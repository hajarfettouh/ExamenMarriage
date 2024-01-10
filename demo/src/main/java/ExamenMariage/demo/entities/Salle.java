package ExamenMariage.demo.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private String Adresse;
    private String Ville;
    private int capacitie;
    @OneToMany(mappedBy = "salle")
    private List<Mariage> mariages = new ArrayList<>();

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public int getCapacitie() {
        return capacitie;
    }

    public void setCapacitie(int capacitie) {
        this.capacitie = capacitie;
    }

    public Salle(Long id, String nom, String adresse, String ville, int capacitie) {
        this.id = id;
        Nom = nom;
        Adresse = adresse;
        Ville = ville;
        this.capacitie = capacitie;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", Adresse='" + Adresse + '\'' +
                ", Ville='" + Ville + '\'' +
                ", capacitie=" + capacitie +
                '}';
    }
}
