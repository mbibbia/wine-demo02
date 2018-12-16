package ch.bibbias.persistence.objects;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "wine_type")
public class WineTypeEntity {

	@Id
	@Column(name = "type_code")
	private String code;
	
	@Column(name = "type_name")
	private String name;

	@OneToMany
	@JoinColumn(name = "wine_id", referencedColumnName = "wine_id")
	private List<WineEntity> wines;

	public WineTypeEntity(String code) {
		this.code = code;
	}

	public WineTypeEntity() {

	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WineEntity> getWines() {
		return this.wines;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
