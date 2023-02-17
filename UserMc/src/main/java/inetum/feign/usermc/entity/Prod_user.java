package inetum.feign.usermc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Prod_user {
    @EmbeddedId
    private id_compose idCompose;

    private String nom_Produit;

    private int prix;
}
