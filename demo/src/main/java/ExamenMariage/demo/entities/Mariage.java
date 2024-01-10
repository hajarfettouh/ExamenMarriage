package ExamenMariage.demo.entities;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mariage {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero", nullable=false)
    private Long id;

    public Personne getPersonneEpoux() {
        return PersonneEpoux;
    }

    public void setPersonneEpoux(Personne personneEpoux) {
        PersonneEpoux = personneEpoux;
    }

    public Personne getPersonneEpouse() {
        return PersonneEpouse;
    }

    public void setPersonneEpouse(Personne personneEpouse) {
        PersonneEpouse = personneEpouse;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public List<Invite> getInvites() {
        return invites;
    }

    public void setInvites(List<Invite> invites) {
        this.invites = invites;
    }

    @Column(insertable=false, updatable=false)
    private Long numero;
    private LocalDate date;
    private int nombreMinimumTemoin;
    private int capaciteMinimal;
    private int nombreMaxInviteEpoux;
    @ManyToOne
    @JoinColumn(name="personne_epoux_id")
    private Personne PersonneEpoux;
    @ManyToOne
    @JoinColumn(name="personne_epouse_id")
    private Personne PersonneEpouse;

    @ManyToOne
    @JoinColumn(name="id_salle")
    private Salle salle;
    @ManyToMany
    @JoinTable(name = "mariage_invites",
            joinColumns = @JoinColumn(name = "mariage_numero"),
            inverseJoinColumns = @JoinColumn(name = "invites_id"))
    private List<Invite> invites=new ArrayList<>();



    public Mariage() {

    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNombreMinimumTemoin() {
        return nombreMinimumTemoin;
    }

    public void setNombreMinimumTemoin(int nombreMinimumTemoin) {
        this.nombreMinimumTemoin = nombreMinimumTemoin;
    }

    public int getCapaciteMinimal() {
        return capaciteMinimal;
    }

    public void setCapaciteMinimal(int capaciteMinimal) {
        this.capaciteMinimal = capaciteMinimal;
    }

    public int getNombreMaxInviteEpoux() {
        return nombreMaxInviteEpoux;
    }

    public void setNombreMaxInviteEpoux(int nombreMaxInviteEpoux) {
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }

    public Mariage(Long numero, LocalDate date, int nombreMinimumTemoin, int capaciteMinimal, int nombreMaxInviteEpoux) {
        this.numero = numero;
        this.date = date;
        this.nombreMinimumTemoin = nombreMinimumTemoin;
        this.capaciteMinimal = capaciteMinimal;
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }

    @Override
    public String toString() {
        return "Mariage{" +
                "numero=" + numero +
                ", date=" + date +
                ", nombreMinimumTemoin=" + nombreMinimumTemoin +
                ", capaciteMinimal=" + capaciteMinimal +
                ", nombreMaxInviteEpoux=" + nombreMaxInviteEpoux +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
