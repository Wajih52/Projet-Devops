package tn.esprit.kaddemproject.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.esprit.kaddemproject.dto.ContractDto;
import tn.esprit.kaddemproject.entities.Contrat;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

//@Component
public class ContractMapper {

    /*@Autowired
    ModelMapper modelMapper;*/

 /*   public ContractDto mapToContractDto(Contrat contrat){
        ContractDto contractDto = modelMapper.map(contrat, ContractDto.class);
        return contractDto;
    }
*/

    public static ContractDto mapToContractDto(Contrat contrat){

        long nbJoursContrat = ChronoUnit.DAYS.between(contrat.getDateDebutContrat(), contrat.getDateFinContrat());
        long montantTotal =  nbJoursContrat/30 * contrat.getMontantContrat();

        ContractDto contractDto =  ContractDto.builder()
                .idContrat(contrat.getIdContrat())
                .dateDebutContrat(contrat.getDateDebutContrat())
                .dateFinContrat(contrat.getDateFinContrat())
                .archive(contrat.getArchive())
                .etudiant(contrat.getEtudiant())
                .montantTotal(montantTotal)
                .build();
        return contractDto;
    }

}
