package com.gerenciador.consultas.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciador.consultas.dto.EmailRequestDTO;
import com.gerenciador.consultas.model.Medico;
import com.gerenciador.consultas.repository.MedicoRepository;
import com.gerenciador.consultas.services.EmailService;
import com.gerenciador.consultas.services.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	private final MedicoRepository repository;
	private final EmailService emailService;
	
	 public MedicoServiceImpl(MedicoRepository repository, EmailService emailService) {
	        this.repository = repository;
	        this.emailService = emailService;
	    }

	

	@Override
    public Medico cadastrar(Medico medico) {
        Medico medicoSalvo = repository.save(medico);

        EmailRequestDTO email = new EmailRequestDTO();
        email.setSmtpHost("smtp.gmail.com"); // ou Gmail com app password
        email.setSmtpPort(587);
        email.setSmtpUsername("pphenriquelim4@gmail.com");
        email.setSmtpPassword("vhsb ygkq gvza vlmp");
        email.setFrom("pphenriquelim4@gmail.com");
        email.setTo(medico.getEmail());
        email.setSubject("Cadastro confirmado");
        email.setBodyHtml(
        	    "<!DOCTYPE html>" +
        	    "<html>" +
        	    "<head>" +
        	    "<meta charset='UTF-8'>" +
        	    "<style>" +
        	    "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }" +
        	    ".email-container { background-color: #ffffff; max-width: 600px; margin: 40px auto; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }" +
        	    ".header { background-color: #007BFF; padding: 20px; border-radius: 8px 8px 0 0; text-align: center; color: white; }" +
        	    ".content { margin: 30px 0; font-size: 16px; color: #333; }" +
        	    ".content h2 { color: #007BFF; }" +
        	    ".footer { font-size: 12px; text-align: center; color: #999; margin-top: 30px; }" +
        	    ".button { display: inline-block; margin-top: 20px; padding: 12px 24px; background-color: #007BFF; color: white; border-radius: 5px; text-decoration: none; }" +
        	    "</style>" +
        	    "</head>" +
        	    "<body>" +
        	    "<div class='email-container'>" +
        	    "<div class='header'><h1>Cadastro realizado com sucesso!</h1></div>" +
        	    "<div class='content'>" +
        	    "<h2>Olá Dr(a). " + medico.getNome() + ",</h2>" +
        	    "<p>Seu cadastro foi concluído com sucesso em nosso sistema.</p>" +
        	    "<p>Agora você pode acessar a plataforma e acompanhar suas consultas.</p>" +
        	    "<a href='https://seusistema.com/login' class='button'>Acessar Sistema</a>" +
        	    "</div>" +
        	    "<div class='footer'>Este é um e-mail automático, por favor não responda.<br>© 2025 Sua Empresa.</div>" +
        	    "</div>" +
        	    "</body>" +
        	    "</html>"
        	);


        emailService.enviarEmail(email);

        return medicoSalvo;
    }

	
	
	@Override
	public List<Medico> listarTodos() {
		
		return repository.findAll();
	}
	
	@Override
	public void excluir(Long id) {
		Medico medico = repository.findById(id)
				.orElseThrow(()-> new RuntimeException("Médico não encontrado"));
		repository.delete(medico);
	}
	


}
