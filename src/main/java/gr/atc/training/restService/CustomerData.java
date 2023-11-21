package gr.atc.training.restService;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class CustomerData {
	List<Customer> customers = new ArrayList<>();
	
	public CustomerData() {
		FileInputStream f;
		try {
			f = new FileInputStream(new ClassPathResource("customers.json").getFile());

		} catch (FileNotFoundException e) {
			f = null;
		} catch (IOException e) {
			f = null;
			e.printStackTrace();
		}

		BufferedReader reader = null;
		reader = new BufferedReader(new InputStreamReader(f));
		String line = null;
		//while()
		try {
			 line = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson jsonReader = new Gson();
		customers = jsonReader.fromJson(line, new TypeToken<List<Customer>>() {}.getType());
	}
	
	public Customer getCustomerById(int id) {
		for(int i=0; i<customers.size(); i++) {
			if (customers.get(i).id == id) {
				 return customers.get(id);
			}
		}
		return null;
	}
}
