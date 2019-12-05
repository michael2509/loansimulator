package fr.formation.loansimulator.repositories;

import fr.formation.loansimulator.entities.LoanSimulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanSimulationRepository extends JpaRepository<LoanSimulation, Long> {
}
