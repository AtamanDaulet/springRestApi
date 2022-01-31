package rest_api04ControllerServiceRepoBasicAuth;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StudentBean05Config {
	@Bean  //Used just in method level if the method is returning an object
	CommandLineRunner commandLineRunner(StudentBean05Repository studentRepo) {
		return args -> {
			StudentBean05 std1 = new StudentBean05(101L, "Ali Can5" , "ac@gmail.com" , LocalDate.of(2002, 3, 12));
			StudentBean05 std2 =  new StudentBean05(102L, "Veli Han5" , "vh@gmail.com" , LocalDate.of(2011, 5, 21));
			StudentBean05 std3 = new StudentBean05(103L, "Mary Star5" , "ms@gmail.com" , LocalDate.of(1996, 7, 5));
			StudentBean05 std4 = new StudentBean05(104L, "Angie Star5" , "as@gmail.com" , LocalDate.of(1997, 10, 11));

			studentRepo.saveAll(List.of(std1, std2, std3, std4));
		};
	}
}
