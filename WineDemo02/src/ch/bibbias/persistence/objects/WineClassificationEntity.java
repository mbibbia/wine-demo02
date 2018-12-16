package ch.bibbias.persistence.objects;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "wine_classification")
public class WineClassificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "classification_code")
	private String code;

	@Column(name = "classification_name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "wine")
	private List<WineEntity> wines;

	public WineClassificationEntity(String code) {
		this.code = code;
	}

	public WineClassificationEntity() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
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
