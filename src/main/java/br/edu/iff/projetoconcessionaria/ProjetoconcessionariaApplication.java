package br.edu.iff.projetoconcessionaria;

import br.edu.iff.projetoconcessionaria.model.Carro;
import br.edu.iff.projetoconcessionaria.model.Cliente;
import br.edu.iff.projetoconcessionaria.model.Concessionaria;
import br.edu.iff.projetoconcessionaria.model.Endereco;
import br.edu.iff.projetoconcessionaria.model.Funcionario;
import br.edu.iff.projetoconcessionaria.model.Reserva;
import br.edu.iff.projetoconcessionaria.model.Telefone;
import br.edu.iff.projetoconcessionaria.repository.ClienteRepository;
import br.edu.iff.projetoconcessionaria.repository.ConcessionariaRepository;
import br.edu.iff.projetoconcessionaria.repository.FuncionarioRepository;
import br.edu.iff.projetoconcessionaria.repository.ReservaRepository;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoconcessionariaApplication implements CommandLineRunner{
    
        @Autowired
        private ClienteRepository clienteRepo;
        
        @Autowired
        private FuncionarioRepository funcionarioRepo;
        
        @Autowired
        private ConcessionariaRepository concessionariaRepo;
        
        @Autowired
        private ReservaRepository reservaRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoconcessionariaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //Cliente
        Cliente c1 = new Cliente();
        c1.setNome("Wanderson");
        c1.setCpf("107.866.777-24");
        c1.setEmail("Wanderson@gmail.com");
        Calendar dt_nascimento = Calendar.getInstance();
        dt_nascimento.set(1998, 01, 02);
        c1.setDt_nascimento(dt_nascimento);
        c1.setHabilitacao("A");
      
        
        Telefone t1 = new Telefone();
        t1.setNumero("(22)99999-9999");
        Telefone t2 = new Telefone();
        t2.setNumero("(22)88888-8888");
        c1.setTelefones(List.of(t1,t2));
        
        Endereco end = new Endereco();
        end.setRua("Rua Oscar de Souza");
        end.setNumero(145);
        end.setBairro("Sítio");
        end.setCidade("Quissamã");
        end.setCep("28735-000");
        c1.setEndereco(end);
        
        clienteRepo.save(c1);
        
        //Funcionario
        
        Funcionario f1 = new Funcionario();
        f1.setNome("João");
        f1.setEmail("Joao@gmail.com");
        f1.setCpf("107.866.777-25");
        f1.setEndereco(end);
        f1.setTelefones(List.of(t1,t2));
        f1.setFuncao("Financeiro");
        f1.setSenha("12345678");
        
        funcionarioRepo.save(f1);
        
        //Concessionaria 
        
        Concessionaria con = new Concessionaria();
        con.setNome("Sport Cars");
        con.setCnpj("07.589.505/0001-82");
        con.setEndereco(end);
        con.setTelefones(List.of(t1,t2));
        
        //Carro
        Carro cr1 = new Carro();
        cr1.setPlaca("KWS3D50");
        cr1.setChassi("9BWZZZ3777VT004251");
        cr1.setRenavam("16272934697");
        cr1.setKm("10000");
        cr1.setModelo("Fiat Uno");
        cr1.setCor("Preto");
        cr1.setAno(2004);
        
        Carro cr2 = new Carro();
        cr2.setPlaca("KSS3D59");
        cr2.setChassi("9BG116G6W04C40001");
        cr2.setRenavam("18653478921");
        cr2.setKm("8000");
        cr2.setModelo("Honda Civic");
        cr2.setCor("Branco");
        cr2.setAno(2012);
        
        con.setCarros(List.of(cr1,cr2));
        
        concessionariaRepo.save(con);
        
        
        Reserva r1 = new Reserva();
        
        r1.setCliente(c1);
        r1.setFuncionario(f1);
        r1.setCarros(List.of(cr1,cr2));
        
        r1.setDatahora(Calendar.getInstance());
        
        Calendar inicio = Calendar.getInstance();
        Calendar termino = Calendar.getInstance();
        inicio.set(2000, 10, 10);
        termino.set(2000, 10, 20);
        r1.setInicio(inicio);
        r1.setTermino(termino);
        
        reservaRepo.save(r1);
        
        
        
    }

}