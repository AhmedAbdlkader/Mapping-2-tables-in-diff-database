package prod.mc.produitmc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prod.mc.produitmc.entity.Produit;

@Repository
public interface Produitrepo extends JpaRepository<Produit,Long> {
}
