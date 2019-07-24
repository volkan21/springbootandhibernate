package com.example.projects.boothibernatejpa.Business;

import java.util.List;

import com.example.projects.boothibernatejpa.Entities.City;

public interface ICityService {
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);

}
