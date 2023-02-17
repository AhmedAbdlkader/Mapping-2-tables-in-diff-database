package prod.mc.produitmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
public class ProduitMcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitMcApplication.class, args);
    }

}
