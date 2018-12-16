package ch.bibbias.persistence.objects;

import javax.persistence.*;

@Entity
@Table(name = "wine")
@NamedQueries({ @NamedQuery(name = "WineEntity.getAllWines", query = "select w from WineEntity w"),
		@NamedQuery(name = "WineEntity.getById", query = "select w from WineEntity w where w.id = :id") })
public class WineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wine_id")
	private Integer id;

	@Column(name = "wine_name")
	private String name;

	@OneToOne
	@JoinColumn(name = "wine_type")
	private WineTypeEntity wineType;
	@JoinColumn(name = "wine_classification")
	private WineClassificationEntity classification;
	@JoinColumn(name = "wine_country")
	private CountryEntity country;
	@JoinColumn(name = "wine_region")
	private RegionEntity region;
	@JoinColumn(name = "wine_producer")
	private ProducerEntity producer;

	public WineEntity(Integer id) {
		this.id = id;

	}

	public WineEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WineTypeEntity getWineType() {
		return wineType;
	}

	public void setWineType(WineTypeEntity wineType) {
		this.wineType = wineType;
	}

	public WineClassificationEntity getClassification() {
		return classification;
	}

	public void setClassification(WineClassificationEntity wineClassification) {
		this.classification = wineClassification;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	public RegionEntity getRegion() {
		return region;
	}

	public void setRegion(RegionEntity region) {
		this.region = region;
	}

	public ProducerEntity getProducer() {
		return producer;
	}

	public void setProducer(ProducerEntity producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
