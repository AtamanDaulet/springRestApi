package rest_api02ServiceController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import rest_api01Controller.StudentBean01;

@Service
public class StudentBean03Service {

	List <StudentBean03> listOfStd = List.of(
			new StudentBean03(101L, "Ali Can" , "ac@gmail.com" , LocalDate.of(2002, 3, 12)),
			new StudentBean03(102L, "Veli Han" , "vh@gmail.com" , LocalDate.of(2011, 5, 21)),
			new StudentBean03(103L, "Mary Star" , "ms@gmail.com" , LocalDate.of(1996, 7, 5)),
			new StudentBean03(104L, "Angie Star" , "as@gmail.com" , LocalDate.of(1997, 10, 11))

			);
			
	public List<StudentBean03> getListOfSudents(){
		return listOfStd;
	}
	 
	public StudentBean03 getStudentById (Long id) {
		
		if(listOfStd.parallelStream().filter(t -> t.getId() == id).collect(Collectors.toList()).isEmpty()) {
			return new StudentBean03();
		}
		return listOfStd.parallelStream().filter(t -> t.getId() == id).findFirst().get();
	}
	
}
