package tacos.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {

  @NotNull
  @Pattern(
      regexp = "[\\w]{5,}[^\\s]*",
      message = "Name must be at least 5 chars long and not include white spaces.")
  private String name;

  @Size(min = 1, message = "You must choose at least 1 ingredient.")
  private List<String> ingredients;
}
