package ch.bibbias.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.bibbias.persistence.objects.RegionEntity;

public class Region {

	private final String DATABASE = "PT_Wine_Inventory";
	private Integer id;
	private RegionEntity persistent;

	public Region() {
		this.persistent = new RegionEntity();
		this.id = this.persistent.getId();

	}

	public Region(Integer id) {
		this.id = id;

		// Load Data
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();

		this.persistent = em.find(RegionEntity.class, this.id);

	}

	Region(RegionEntity persistent) {
		if (persistent != null) {
			this.persistent = persistent;
			this.id = this.persistent.getId();
		}
	}

	public long getId() {
		return this.persistent.getId();
	}

	public Country getCountry() {
		return new Country(this.persistent.getCountry());

	}

	public String getName() {
		return this.persistent.getName();
	}

	public void reset() {
		// this.persistent = new RegionEntity(this.id);
	}

	public void save() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(this.persistent);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}

	public void delete() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.DATABASE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		RegionEntity r = em.find(RegionEntity.class, this.persistent.getId());
		em.remove(r);
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
		Region other = (Region) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
