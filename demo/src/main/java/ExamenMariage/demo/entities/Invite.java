package ExamenMariage.demo.entities;


import ExamenMariage.demo.StatutInvite;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Invite extends Personne {
    @Enumerated(EnumType.STRING)
    private StatutInvite statut;
    @ManyToMany(mappedBy = "invites")
    @JsonIgnore
    private List<Mariage> mariages= new ArrayList<>();

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }

    public Invite(String CIN, String prenom, StatutInvite statut){
        super(CIN,prenom);
        this.statut=statut;
    }



    public StatutInvite getStatut() {
        return statut;
    }

    public void setStatut(StatutInvite statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "statut=" + statut +
                '}';
    }
}
