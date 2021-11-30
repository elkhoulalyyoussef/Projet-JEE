package org.sid.inoventoryservice;
import org.sid.inoventoryservice.entite.Product;
import org.sid.inoventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
@SpringBootApplication
public class InoventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InoventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"acer",5000,55));
            productRepository.save(new Product(null,"asus",8500,10));
            productRepository.save(new Product(null,"hp",7500,596));
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }
}
