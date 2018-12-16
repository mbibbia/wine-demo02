package ch.bibbias.persistence.objects;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "country")
public class CountryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "country_code", length = 2)
	private String code;

	@Column(name = "country_name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER /* LAZY */, mappedBy = "country")
	@JoinColumn(name = "country_regions")
	private List<RegionEntity> regions;

	public CountryEntity(String code) {
		this.code = code;

	}

	public CountryEntity() {

	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RegionEntity> getRegions() {
		return regions;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
