package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.config.Configuration;
import ch.bibbias.persistence.objects.CountryEntity;
import ch.bibbias.persistence.objects.ProducerEntity;
import ch.bibbias.persistence.objects.RegionEntity;
import ch.bibbias.persistence.objects.WineClassificationEntity;
import ch.bibbias.persistence.objects.WineEntity;
import ch.bibbias.persistence.objects.WineTypeEntity;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Wine {

	private Integer id;
	private WineEntity persistent;

	public Wine() {
		this.persistent = new WineEntity();
		this.id = this.persistent.getId();

	}

	public Wine(Integer id) {
		this.id = id;

		// Load Data
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Configuration.DATABASE);
		EntityManager em = emf.createEntityManager();

		this.persistent = em.find(WineEntity.class, this.id);

	}

	public Wine(WineEntity persistent) {
		if (persistent != null) {
			this.persistent = persistent;
			this.id = this.persistent.getId();
		}
	}

	public IntegerProperty getIdProperty() {
		return new SimpleIntegerProperty(this.persistent.getId());
	}

	public long getId() {
		return this.id;

	}

	public StringProperty getNameProperty() {
		return new SimpleStringProperty(this.persistent.getName());

	}

	public String getName() {
		return this.persistent.getName();
	}

	public void setName(String name) {
		this.persistent.setName(name);
	}

	public StringProperty getTypeProperty() {
		if (this.persistent.getWineType() == null) {
			return null;
		}
		return new SimpleStringProperty(this.persistent.getWineType().getName());
	}

	public WineType getType() {
		return new WineType(this.persistent.getWineType());
	}

	public void setClassification(WineClassification classification) {
		this.persistent.setClassification(new WineClassificationEntity(classification.getCode()));
	}

	public void setType(WineType wineType) {
		this.persistent.setWineType(new WineTypeEntity(wineType.getCode()));
	}

	public void setCountry(Country country) {
		this.persistent.setCountry(new CountryEntity(country.getCode()));
	}

	public void setRegion(Region region) {
		this.persistent.setRegion(new RegionEntity(region.getId()));
	}

	public void setProducer(Producer producer) {
		this.persistent.setProducer(new ProducerEntity(producer.getId()));
	}

	public StringProperty getClassificationProperty() {
		if (this.persistent.getClassification() != null) {
			return null;
		}
		return new SimpleStringProperty(this.persistent.getClassification().getName());
	}

	public WineClassification getClassification() {
		return new WineClassification(this.persistent.getClassification());
	}

	public StringProperty getCountryProperty() {
		if (this.persistent.getCountry() == null) {
			return null;
		}
		return new SimpleStringProperty(this.persistent.getCountry().getName());

	}

	public Country getCountry() {
		return new Country(this.persistent.getCountry());
	}

	public StringProperty getRegionProperty() {
		if (this.persistent.getRegion() == null) {
			return null;
		}
		return new SimpleStringProperty(this.persistent.getRegion().getName());

	}

	public Region getRegion() {
		if (this.persistent.getRegion() != null) {
			return new Region(this.persistent.getRegion());
		} else {
			return new Region();
		}

	}

	public StringProperty getProducerProperty() {
		if (this.persistent.getProducer() != null) {
			return new SimpleStringProperty(this.persistent.getProducer().getName());
		} else {
			return null;
		}
	}

	public Producer getProducer() {
		if (this.persistent.getProducer() != null) {
			return new Producer(this.persistent.getProducer());
		} else {
			return new Producer();
		}

	}

	public void reset() {
		this.persistent = new WineEntity(this.id);
	}

	public void save() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Configuration.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		if (this.persistent.getId() == 0) {
			em.persist(this.persistent);
		}

		em.getTransaction().commit();
		em.close();
		emf.close();

		this.id = this.persistent.getId();

	}

	public void delete() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Configuration.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		WineEntity w = em.find(WineEntity.class, this.persistent.getId());
		em.remove(w);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}

	@Override
	public String toString() {
		return this.persistent.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wine other = (Wine) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
