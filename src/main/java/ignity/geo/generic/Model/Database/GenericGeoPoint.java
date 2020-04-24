package ignity.geo.generic.Model.Database;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class GenericGeoPoint {

    @Id
    private int id;
    private String name;
    private String description;
    private String image;
    private String icon;
    private double lat;
    private double lon;
    private short available;
    private String email;

    public GenericGeoPoint() {

    }
}
