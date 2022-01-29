package rest_api01Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentBean01Controller {
	// it tells spring boot that this method will be used in requests
	//@RequestMapping(method = RequestMethod.GET, path = "/getRequest") 
	
	@GetMapping(path = "/getRequest") 
	//To be able to see the message on the console
	@ResponseBody
	public String getMethod1() {
		return "Get Request method is executed ...";
	}
	// Using @RestController and @GetMapping(path="/getRequest") is better because it's shorter
		// In this method we returned just String
	
	@GetMapping(path = "/getObject")
	@ResponseBody
	public StudentBean01 getMethod2() {
		return new StudentBean01 ("AC202113", "Ali Can", 13);
	}
	
	//The previous method is tight coupling, to make it loose coupling type the following method
	
	@Autowired //this annotation means that you assigned the object(bean) to the s object
	StudentBean01 s;
	
	@GetMapping(path = "/getXXX")
	@ResponseBody
	public StudentBean01 getMethod3() {
		//return s = new StudentBean01 (1001, "Ali Can", 13);
		s.setAge(13);
		s.setName("Ali Can");
		s.setId("AC202113");
		return s;
	}
	
	// to return a parameterized object you should create this method:
	
	
	@GetMapping(path= "/getParameterized/{school}")
	@ResponseBody
	public StudentBean01 getMethod4 (@PathVariable String school) {
		return s2 = new StudentBean01 ( String.format("AC%s202113", school), "Ali Can" , 13);
		
		//be careful about path="/getParameterized/{school}" and getMethod4 (@PathVariable String school)
		// this is tight coupling
	}
		
	@Autowired 
	StudentBean01 s2;
	@GetMapping(path= "/getParameterized2/{school}")
	@ResponseBody
	public StudentBean01 getMethod5 (@PathVariable String school) {
		return s2 = new StudentBean01 ( String.format("AC%s202113", school), "Ali Can" , 13);		
	}	
	
  //For this method, we will learn loose coupling in Repository Layer 
    
    //If you do not put any path inside the @GetMapping paranthesis it works as well
	@GetMapping(path= "/getList")
	@ResponseBody
	public List <StudentBean01> getMethod6 () {
		return List.of(
				new StudentBean01 ("AC202113", "Ali Can", 10),
				new StudentBean01 ("AC202113", "Joe Dow", 15),
				new StudentBean01 ("AC202113", "John Galt", 12)
				);		
	}
	
//	@Autowired 
//	List <StudentBean01> s3;
//	@GetMapping(path= "/getList2")
//	@ResponseBody
//	public List <StudentBean01> getMethod7 () {
//		
//		s3.addAll(List.of(
//				new StudentBean01 ("AC202113", "Ali Can", 10),
//				new StudentBean01 ("AC202113", "Joe Dow", 15),
//				new StudentBean01 ("AC202113", "John Galt", 12)
//				));
//		
//		return s3;		
//	}
	
	
	// You cannot use same path inside the @GetMapping paranthesis it does not work
	
	@Autowired 
	StudentBean01 std;
	@GetMapping(path= "/getMessage")
	@ResponseBody
	public String getMethod7 () {
		return std.study();		
	}	
	
	@Autowired 
	@Qualifier(value = "studentBean01")
	StudentInterface std2;
	@GetMapping(path= "/getMessage2")
	@ResponseBody
	public String getMethod8 () {
		return std2.study();		
	}	
	
}
