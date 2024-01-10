package ExamenMariage.demo.services;

import ExamenMariage.demo.entities.Mariage;
import ExamenMariage.demo.entities.Personne;
import ExamenMariage.demo.entities.Salle;
import ExamenMariage.demo.repositories.InviteRepository;
import ExamenMariage.demo.repositories.MariageRepository;
import ExamenMariage.demo.repositories.PersonneRepository;
import ExamenMariage.demo.repositories.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {
    private final PersonneRepository personneRepository;
    private final InviteRepository inviteRepository;
    private final MariageRepository mariageRepository;
    private final SalleRepository salleRepository;
    private final MariageService mariageService;

    public PersonneService(PersonneRepository personneRepository, InviteRepository inviteRepository, MariageRepository mariageRepository, SalleRepository salleRepository,MariageService mariageService) {
        this.personneRepository = personneRepository;
        this.mariageService=mariageService;
        this.inviteRepository = inviteRepository;
        this.mariageRepository = mariageRepository;
        this.salleRepository = salleRepository;
    }
    public List<Personne> findAll(){
        return personneRepository.findAll();
    }
    public Personne findById(Long id){
        return personneRepository.findById(id).orElseThrow(()-> new RuntimeException("personne with id "+ id +"is not exist"));
    }
    public Personne AddPersonne(Personne personne){
        return personneRepository.save(personne);
    }
    public Personne updatePersonne(Personne personne){
        if(personneRepository.findById(personne.getId())!=null){
            return personneRepository.save(personne);
        }
        return null;
    }
    public void deletePersonne(Long id ){
        personneRepository.deleteById(id);
    }
    public Mariage reserver(Long homeId , Long femmeId,Mariage mariage){
        Personne homme=findById(homeId);
        Personne femme=findById(femmeId);
        homme.getMariageEpoux().add(mariage);
        femme.getMariageEpouse().add(mariage);
        mariage.setPersonneEpoux(homme);
        mariage.setPersonneEpouse(femme);
        personneRepository.save(homme);
        personneRepository.save(femme);
        mariageRepository.save(mariage);
        return mariage;

    }
    public Salle confirmer(Long mariageNumero, Salle salle){
        Mariage mariage=mariageService.findById(mariageNumero);
        if(mariage.getCapaciteMinimal()<=salle.getCapacitie()){
            mariage.setSalle(salle);
            salle.getMariages().add(mariage);
            salleRepository.save(salle);
            mariageRepository.save(mariage);

        }
        return salle;


    }


}
