package tn.esprit.kaddemproject;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.kaddemproject.entities.Contrat;
import tn.esprit.kaddemproject.services.IContratService;

@SpringBootTest

public class ContratTests {

    @Autowired
    IContratService contratService ;
    @Test
    public void testAddContrat(){
      //  Contrat contrat = new Contrat();

    }

    @Test
    public void testDeleteContrat(){

    }
}
