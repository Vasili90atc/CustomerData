package gr.atc.training.customerAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class CustomerController {
	@Autowired
	private CustomerData cd;

	@GetMapping("/customer/{id}")
	public ResponseEntity<String> getCustomerInfoById(@PathVariable int id) {
		System.out.println("Id of customer we are looking for: " + Integer.toString(id));
		String line = cd.getCustomerById(id);
		return ResponseEntity.ok(line);
	}
}
