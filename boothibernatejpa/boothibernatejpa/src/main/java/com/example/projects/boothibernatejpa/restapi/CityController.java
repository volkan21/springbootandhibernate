package com.example.projects.boothibernatejpa.restapi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// bu kısım uygulamamızın son noktasıdır api kısmı o yüzden api yani restcontroller olabilmesi için annotasyonu
//yapıştıryoruz

import com.example.projects.boothibernatejpa.Business.ICityService;
import com.example.projects.boothibernatejpa.Entities.City;

@RestController
@RequestMapping("/api") 
public class CityController {
	private ICityService cityservice;
@Autowired 
	public CityController(ICityService cityservice) {
		this.cityservice = cityservice;
	}
@GetMapping("/cities") 
public List<City> get(){
	return cityservice.getAll();
	
}
@PostMapping("/add") //ekleme operasyonu
public void add(@RequestBody City city) {
	cityservice.add(city);
}
@PostMapping("/update") //update operasyonu
public void update(@RequestBody City city) {
	cityservice.update(city);
}
@PostMapping("/delete") //delete operasyonu
public void delete(@RequestBody City city) {
	cityservice.delete(city);
}
@PostMapping("/cities/{id}")
public City getbyID(@PathVariable int id) {
		return cityservice.getById(id);
	
	
}
	
	

}
