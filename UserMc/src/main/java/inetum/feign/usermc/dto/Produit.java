package inetum.feign.usermc.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Produit {
    private long id;
    private String nom;
    private int prix;

}
