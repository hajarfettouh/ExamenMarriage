package ExamenMariage.demo.controllers;


import ExamenMariage.demo.entities.Mariage;
import ExamenMariage.demo.entities.Personne;
import ExamenMariage.demo.entities.Salle;
import ExamenMariage.demo.services.MariageService;
import ExamenMariage.demo.services.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personne")
public class PersonneController {
    private final PersonneService personneService;
    private final MariageService mariageService;

    public PersonneController(PersonneService personneService, MariageService mariageService) {
        this.personneService = personneService;
        this.mariageService = mariageService;
    }
    @GetMapping("/All")
    public List<Personne> getAll() {
        List<Personne> personnes = personneService.findAll();
        return personnes;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Personne personne = personneService.findById(id);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }

    @PostMapping("/add")
    public Personne add(@RequestBody Personne personne) {
        Personne newPersonne = personneService. AddPersonne(personne);
        return newPersonne;
    }

    @PutMapping("/update")
    public Personne update(@RequestBody Personne personne) {
        Personne newPersonne = personneService.updatePersonne(personne);
        return newPersonne;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        personneService.deletePersonne(id);
    }

    @PostMapping("/reserver")
    public Mariage reserver(Long hommeId, Long femmeId,@RequestBody Mariage mariage ){
            Mariage mariageReserver=personneService.reserver(hommeId,femmeId,mariage);
            return mariageReserver;
    }
    @PostMapping("/confirmer")
    public Salle reserver(Long mariageNumero,@RequestBody Salle salle){
        Salle salleConfirme=personneService.confirmer(mariageNumero,salle);
        return salleConfirme;
    }



}
