package ExamenMariage.demo;

import ExamenMariage.demo.services.InviteService;
import ExamenMariage.demo.services.MariageService;
import ExamenMariage.demo.services.PersonneService;
import ExamenMariage.demo.services.SalleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamenMariageApplication {
	private  final SalleService salleService;
	private final PersonneService personneService;
	private final MariageService mariageService;
	private final InviteService inviteService;

	public ExamenMariageApplication(SalleService salleService, PersonneService personneService, MariageService mariageService, InviteService inviteService) {
		this.salleService = salleService;
		this.personneService = personneService;
		this.mariageService = mariageService;
		this.inviteService = inviteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExamenMariageApplication.class, args);
	}

}
