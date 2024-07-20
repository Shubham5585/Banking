package Banking.Repo;

import Banking.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomeRepo extends JpaRepository<Customer,Long>
{
    
}
