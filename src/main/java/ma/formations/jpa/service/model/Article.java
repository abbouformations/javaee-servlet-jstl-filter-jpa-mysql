package ma.formations.jpa.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Article {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private Double quantite;
	private Double price;
}
