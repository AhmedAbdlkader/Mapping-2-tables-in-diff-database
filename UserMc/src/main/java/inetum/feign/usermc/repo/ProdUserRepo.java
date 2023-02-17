package inetum.feign.usermc.repo;

import inetum.feign.usermc.entity.Prod_user;
import inetum.feign.usermc.entity.id_compose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdUserRepo extends JpaRepository<Prod_user, id_compose> {
}
