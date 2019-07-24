package com.example.projects.boothibernatejpa.Dataaccess;
import java.util.List;
import com.example.projects.boothibernatejpa.Entities.City;;



public interface ICityDal {
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getbyId(int id);
	

}
