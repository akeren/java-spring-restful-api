package uk.ac.bolton.boltonuniversitybankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.bolton.boltonuniversitybankingapp.entity.Account;

public interface  AccountRepository extends JpaRepository<Account, Long> {

}
