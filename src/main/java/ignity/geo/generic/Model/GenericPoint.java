package ignity.geo.generic.Model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class GenericPoint {
    private String name;
    private Boolean active;
    private double lat;
    private double lon;

}
