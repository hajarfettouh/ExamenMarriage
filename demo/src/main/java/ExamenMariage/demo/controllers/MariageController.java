package ExamenMariage.demo.controllers;

import ExamenMariage.demo.entities.Invite;
import ExamenMariage.demo.entities.Mariage;
import ExamenMariage.demo.repositories.InviteRepository;
import ExamenMariage.demo.repositories.MariageRepository;
import ExamenMariage.demo.services.InviteService;
import ExamenMariage.demo.services.MariageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/mariage")
public class MariageController {
    private final MariageService mariageService;

    public MariageController(MariageService mariageService) {
        this.mariageService = mariageService;
    }
    @GetMapping("/all")
    public List<Mariage> getAll(){
        List<Mariage> mariages=mariageService.findAll();
        return mariages;
    }
    @GetMapping("/find/{id}")
    public Mariage getById(@PathVariable("id") Long id) {
        Mariage mariage = mariageService.findById(id);
        return mariage;
    }
    @PutMapping("/update")
    public Mariage update(@RequestBody Mariage mariage){
        Mariage newMariage=mariageService.updateMariage(mariage);
        return newMariage;
    }
    @PostMapping("/add")
    public Mariage add(@RequestBody Mariage mariage){
        Mariage newMariage=mariageService.addMariage(mariage);
        return newMariage;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        mariageService.deleteMariage(id);

    }
    @PostMapping("/addInvitation")
    public Mariage addInvitation(Long mariageNumero, Invite invite ){
        Mariage mariage=mariageService.addInviation(mariageNumero,invite);
        return mariage;
    }


}
