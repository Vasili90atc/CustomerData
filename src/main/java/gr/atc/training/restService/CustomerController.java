package gr.atc.training.restService;

import java.util.List;

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
	public ResponseEntity<Customer> getCustomerInfoById(@PathVariable int id) {
		System.out.println("Id of customer we are looking for: " + Integer.toString(id));
		Customer c = cd.getCustomerById(id);
		return ResponseEntity.ok(c);
	}

	@GetMapping("/customer/name/{name}")
	public ResponseEntity<List<Customer>> getfindCustomerByName(@PathVariable String name) {
		List<Customer> customers = cd.findByName(name);
		return ResponseEntity.ok(customers);
	}
	 /* @GetMapping("/customer/name/{firstname}")
	public ResponseEntity<List<Customer>> getfindCustomerByName(@PathVariable String firstname) {
		List<Customer> customers = cd.getCustomerByName(firstname);
		return ResponseEntity.ok(customers);
	} */

}