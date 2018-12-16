package ch.bibbias.persistence.objects;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "producer")
public class ProducerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "producer_name")
	private String name;
	@Column(name = "producer_company")
	private String company;
	@Column(name = "producer_addressline_1")
	private String addressLine1;
	@Column(name = "producer_addressline_2")
	private String addressLine2;
	@Column(name = "producer_zip_code")
	private String zipCode;
	@Column(name = "producer_place")
	private String place;
	@Column(name = "producer_phone")
	private String phone;
	@Column(name = "producer_fax")
	private String fax;
	@Column(name = "producer_email")
	private String eMail;
	@Column(name = "producer_url")
	private String url;

	@OneToOne
	@JoinColumn(name = "producer_country")
	private CountryEntity country;

	@JoinColumn(name = "producer_region")
	private RegionEntity region;

	@OneToMany
	@JoinColumn(name = "wine_id", referencedColumnName = "wine_id")
	private List<WineEntity> wines;

	public ProducerEntity(Integer id) {
		this.id = id;

	}

	public ProducerEntity() {

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public List<WineEntity> getWines() {
		return wines;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
