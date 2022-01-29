package rest_api03RepositoryServiceController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StudentBean04Config {
	@Bean
	CommandLineRunner commandLineRunner(StudentBean04Repository studentRepo) {
		return args -> {
			StudentBean04 std1 = new StudentBean04(101L, "Ali Can" , "ac@gmail.com" , LocalDate.of(2002, 3, 12));
			StudentBean04 std2 =  new StudentBean04(102L, "Veli Han" , "vh@gmail.com" , LocalDate.of(2011, 5, 21));
			StudentBean04 std3 = new StudentBean04(103L, "Mary Star" , "ms@gmail.com" , LocalDate.of(1996, 7, 5));
			StudentBean04 std4 = new StudentBean04(104L, "Angie Star" , "as@gmail.com" , LocalDate.of(1997, 10, 11));

			studentRepo.saveAll(List.of(std1, std2, std3, std4));
		};
	}
}
