package prod.mc.produitmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 import prod.mc.produitmc.entity.Produit;
import prod.mc.produitmc.repo.Produitrepo;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    Produitrepo repo;





    @GetMapping("All")

    public List<Produit> listProduit() {
        return repo.findAll();
    }

    @GetMapping("one/{id}")

    public Produit OneByid(@PathVariable long id) {

        return repo.findById(id).orElseGet(null);

    }


    @PostMapping("add")
    public Produit AddProduit(@RequestBody Produit u) {
        return repo.save(u);
    }

}
