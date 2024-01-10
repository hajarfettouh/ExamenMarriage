package ExamenMariage.demo.controllers;


import ExamenMariage.demo.entities.Invite;
import ExamenMariage.demo.services.InviteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invit")
public class InvitController {
  private final InviteService inviteService;

    public InvitController(InviteService inviteService) {
        this.inviteService = inviteService;
    }
    @GetMapping("/all")
    public List<Invite> getAll(){
        List<Invite> invites=inviteService.findAll();
        return invites;
    }
    @GetMapping("/find/{id}")
    public Optional<Invite> getById(@PathVariable("id") Long id){
        Optional<Invite> invite=inviteService.findById(id);
        return invite;
    }
    @GetMapping("/update")
    public Invite update(@RequestBody Invite invite){
        Invite newInvite=inviteService.updateInvite(invite);
        return newInvite;
    }
    @GetMapping("/add")
    public Invite add(@RequestBody Invite invite){
        Invite newInvite=inviteService.addInvite(invite);
        return newInvite;
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        inviteService.deleteInvite(id);

    }

}
