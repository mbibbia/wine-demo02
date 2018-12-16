package ch.bibbias.persistence.objects;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class CountryEntity {

	@Id
	@Column(name = "country_code", length = 2)
	private String code;

	@Column(name = "country_name")
	private String name;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<RegionEntity> regions = new ArrayList<RegionEntity>();

	@OneToMany
	@JoinColumn(name = "wine_id", referencedColumnName = "wine_id")
	private List<WineEntity> wines = new ArrayList<WineEntity>();

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
