package com.example.projects.boothibernatejpa.Dataaccess;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.projects.boothibernatejpa.Entities.City;
@Repository
public class HibernateCityDal implements ICityDal {
	
	private EntityManager entitymanager; //session factory otomatik olarak enjekte edicez
	
@Autowired //gerekli olan enjeksiyonu yapar autowired annotasyonu ile
	public HibernateCityDal(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	@Override
	@Transactional // bizim için trascation açar 
	//yazılan kodumuz build edildipi zaman sessiın açma kapama kısımlarını koymamıza yardımcı olur
	public List<City> getAll() {
		// database deki tüm city tablosunu bize çekme işlemini yapar
		//jpa bizim için bizim için gerekli olan enjeksiyonları yapıyor
	Session session=entitymanager.unwrap(Session.class); 
	List<City> cities=session.createQuery("from City",City.class).getResultList();
		
		return cities;
	}

	@Override
	public void add(City city) {
		Session session=entitymanager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
		
		
	}

	@Override
	public void update(City city) {
		Session session=entitymanager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
		
		
	}

	@Override
	public void delete(City city) {
		Session session=entitymanager.unwrap(Session.class);
		City citytodelete=session.get(City.class,city.getId());
		session.delete(citytodelete);
	
		
	}

	@Override
	public City getbyId(int id) {
		Session session=entitymanager.unwrap(Session.class);
		City city=session.get(City.class, id);
		return city;
		
	}

	

}
