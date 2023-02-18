package tn.esprit.kaddemproject;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.kaddemproject.entities.Universite;
import tn.esprit.kaddemproject.repositories.UniversiteRepository;
import tn.esprit.kaddemproject.services.IUniversiteService;
import tn.esprit.kaddemproject.services.IUniversiteServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UniversiteTest {
    @Mock
    UniversiteRepository universiteRepository;
    @InjectMocks
    IUniversiteServiceImpl universiteServiceimpl;

    @Test
    public void testRetrieveUniversiteByID(){

        Universite universite = new Universite(115, "universite test");
        Mockito.when(universiteRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(universite));
        assertNotNull(universiteServiceimpl.retriveUniversite());

    }

    @Test
    public void testAssignUniversiteToDepartement(){
        Universite universite = new Universite(110, "universiteaddtest");
        //Mockito
    }
    
}
