package com.alex.analise_credito;
import com.alex.analise_credito.service.strategy.AnaliseCreditoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnaliseCreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnaliseCreditoApplication.class, args);
	}

    /*
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            service.analisar();
        };
    }
    */
}
