package ignity.geo.generic.Model.Database;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class GenericGeoPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String image;
    private String icon;
    private double lat;
    private double lon;
    private short available;
    private String email;

    protected GenericGeoPoint() {

    }
}
