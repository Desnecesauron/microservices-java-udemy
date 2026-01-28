package br.com.desnecesauron.hrworker.repositories;

import br.com.desnecesauron.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
