package ExamenMariage.demo.services;

import ExamenMariage.demo.entities.Invite;
import ExamenMariage.demo.entities.Mariage;
import ExamenMariage.demo.repositories.InviteRepository;
import ExamenMariage.demo.repositories.MariageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MariageService {
    private final MariageRepository mariageRepository;
    private final InviteRepository inviteRepository;

    public MariageService(MariageRepository mariageRepository, InviteRepository inviteRepository) {
        this.mariageRepository = mariageRepository;
        this.inviteRepository = inviteRepository;
    }
    public List<Mariage> findAll(){
        return mariageRepository.findAll();
    }
    public Mariage findById(Long id){
        return mariageRepository.findById(id).orElseThrow(()->new RuntimeException("lariage with numero"+id+"is not found"));
    }

    public Mariage addMariage(Mariage mariage){
        return mariageRepository.save(mariage);
    }
    public Mariage updateMariage(Mariage mariage){
        if(mariageRepository.findById(mariage.getId())!=null){
            return mariageRepository.save(mariage);
        }
        return null;
    }
    public void deleteMariage(Long id){
         mariageRepository.deleteById(id);
    }
    public Mariage addInviation(Long mariageNumero, Invite invite){
        Mariage mariage=findById(mariageNumero);
        mariage.getInvites().add(invite);
        invite.getMariages().add(mariage);
        inviteRepository.save(invite);
        mariageRepository.save(mariage);
        return mariage;
    }
}
