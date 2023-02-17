package inetum.feign.usermc.controller;


import inetum.feign.usermc.dto.Produit;
import inetum.feign.usermc.entity.User;
import inetum.feign.usermc.entity.id_compose;
import inetum.feign.usermc.entity.Prod_user;
import inetum.feign.usermc.repo.ProdUserRepo;
import inetum.feign.usermc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo repo;

    @Autowired
    ProdUserRepo prodUserRepo;

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("All")

    public List<User> ListUser ()
    {
        return repo.findAll();
    }

    @PostMapping("add")
    public User AddUser( @RequestBody User u )
    {
        return repo.save(u);
    }


@GetMapping("prodfuser")
    public ResponseEntity<List<Produit>> produit()
    {
        RequestEntity<?> entity = RequestEntity.get("http://localhost:8083/produit/All")
                .build();
        ResponseEntity<List<Produit>> result = restTemplate.exchange(entity,new ParameterizedTypeReference<List<Produit>>(){});

        return ResponseEntity.ok(result.getBody());
    }


    @PostMapping("Affecter/{id}/{idp}")
    public Prod_user affecterProduitToUser( @PathVariable("id")  long id ,@PathVariable("idp") long idp  )
    {

        RequestEntity<?> entity = RequestEntity.get("http://localhost:8083/produit/one/"+idp)
                .build();
        ResponseEntity<Produit> result =restTemplate.exchange(entity,Produit.class);
         Prod_user pu=new Prod_user();
        pu.setIdCompose(new id_compose(id,result.getBody().getId()));
        pu.setNom_Produit(result.getBody().getNom());
        pu.setPrix(result.getBody().getPrix());
        return prodUserRepo.save(pu);

    }











}
