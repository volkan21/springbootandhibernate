package com.example.projects.boothibernatejpa.Business;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.projects.boothibernatejpa.Dataaccess.ICityDal;
import com.example.projects.boothibernatejpa.Entities.City;
@Service // iş katmanlarımızı bur kısımda yönetilir
public class CityManager implements ICityService {
	private ICityDal citydal;
	
@Autowired 
	public CityManager(ICityDal citydal) {
		this.citydal = citydal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		 return citydal.getAll();
		
		
		
	}

	@Override
	@Transactional
	public void add(City city) {
		
		citydal.add(city);
	
		
	}

	@Override
	@Transactional
	public void update(City city) {
		citydal.update(city);
		
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		citydal.delete(city);
		
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		
		return citydal.getbyId(id);
	}

}
