package ignity.geo.generic.Service;

import ignity.geo.generic.Model.GenericPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiceGenericPoints {

    public List<GenericPoint> retrieveAllGenericPoints(){
        return new ArrayList<>(Arrays.asList(
                new GenericPoint("Name",Boolean.TRUE, -12.3133223,96.24344),
                new GenericPoint("Name2",Boolean.TRUE, -12.3133223,96.24344)));
    }

    public ResponseEntity createGenericPoint(GenericPoint genericPoint) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity updateGenericPoint(GenericPoint any) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity deleteGenericPoint(long idGenericPoint) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
