package ch.bibbias.persistence.objects;

import javax.persistence.*;

@Entity
@Table(name = "region")
public class RegionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "region_name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "country")
	private CountryEntity country = new CountryEntity();

	public RegionEntity(Integer id) {
		this.id = id;

	}

	public RegionEntity() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
