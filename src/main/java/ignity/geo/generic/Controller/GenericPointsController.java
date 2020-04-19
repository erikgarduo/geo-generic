package ignity.geo.generic.Controller;

import ignity.geo.generic.Model.GenericPoint;
import ignity.geo.generic.Service.ServiceGenericPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenericPointsController {

    @Autowired
    ServiceGenericPoints serviceGenericPoints;

    @GetMapping("/generic-point")
    public GenericPoint retrieveOneGenericPoint(@RequestParam long idGenericPoint){
        return new GenericPoint("Name",Boolean.TRUE, -12.3133223,96.24344);
    }

    @GetMapping("/all-generic-point")
    public List<GenericPoint> retrieveAllGenericPoints(){
        return serviceGenericPoints.retrieveAllGenericPoints();
    }

    @PostMapping("/generic-point")
    public ResponseEntity createGenericPoint(@RequestBody GenericPoint genericPoint){
        return serviceGenericPoints.createGenericPoint(genericPoint);
    }

    @PutMapping("/generic-point/{idGenericPoint}")
    public ResponseEntity updateGenericPoint(@RequestBody GenericPoint genericPoint,@PathVariable long idGenericPoint){
        return serviceGenericPoints.updateGenericPoint(genericPoint);
    }

    @DeleteMapping("/generic-point/{idGenericPoint}")
    public ResponseEntity deleteGenericPoint(@PathVariable long idGenericPoint){
        return serviceGenericPoints.deleteGenericPoint(idGenericPoint);
    }
}
