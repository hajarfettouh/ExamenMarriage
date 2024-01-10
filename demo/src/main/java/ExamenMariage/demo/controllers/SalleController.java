package ExamenMariage.demo.controllers;

import ExamenMariage.demo.entities.Salle;
import ExamenMariage.demo.services.SalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salle")
public class SalleController {
    private SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }
    @GetMapping("/all")
    public List<Salle> findAll(){
        return salleService.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Salle> findById(@PathVariable("id") Long id){
        return salleService.findById(id);
    }
    @PostMapping("/add")
    public Salle AddSalle(@RequestBody  Salle salle){
        Salle newsalle=salleService.addSalle(salle);
        return newsalle;
    }
    @PutMapping("/update")
    public Salle UpdateSalle(@RequestBody Salle salle){
        Salle newsalle=salleService.updateSalle(salle);
        return newsalle;
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteSalle(@PathVariable("id") Long id){
        salleService.deleteSalle(id);
    }
}
