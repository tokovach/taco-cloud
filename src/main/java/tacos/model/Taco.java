package tacos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Date createdAt;

  @NotNull
  @Pattern(
      regexp = "[\\w]{5,}[^\\s]*",
      message = "Name must be at least 5 chars long and not include white spaces.")
  private String name;

  @ManyToMany(targetEntity = Ingredient.class)
  @Size(min = 1, message = "You must choose at least 1 ingredient.")
  private List<String> ingredients;

  @PrePersist
  void createdAt() {
    this.createdAt = new Date();
  }
}
