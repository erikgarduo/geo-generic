package ignity.geo.generic.Service;

import ignity.geo.generic.Model.Database.GenericGeoPoint;
import ignity.geo.generic.Model.GenericPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiceGenericGeoPoint {

    public List<GenericGeoPoint> retrieveAllGenericGeoPoints(){
        return new ArrayList<>(Arrays.asList(
                new GenericGeoPoint(1,"Building 1","description1","images/image1","icons/icon1", -98.131233,120.23454,(short)1,"email1@gmail.com"),
                new GenericGeoPoint(2,"Building 2","description2","images/image2","icons/icon2", -97.131233,117.23454,(short)1,"email2@gmail.com")));
    }

    public ResponseEntity createGenericGeoPoint(GenericGeoPoint genericPoint) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity updateGenericGeoPoint(GenericGeoPoint any) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity deleteGenericGeoPoint(long idGenericGeoPoint) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
