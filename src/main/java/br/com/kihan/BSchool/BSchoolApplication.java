package br.com.kihan.BSchool;

import br.com.kihan.BSchool.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(BSchoolApplication.class, args);
	}

}
