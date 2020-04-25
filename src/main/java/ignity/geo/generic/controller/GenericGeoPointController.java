package ignity.geo.generic.controller;

import ignity.geo.generic.Model.Database.GenericGeoPoint;
import ignity.geo.generic.Service.ServiceGenericGeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class GenericGeoPointController {

    @Autowired
    private ServiceGenericGeoPoint serviceGenericGeoPoint;

    static final String uriResource="/{idGenericPoint}";

    @GetMapping("/generic-geo-point/{idGenericPoint}")
    public GenericGeoPoint retrieveOneGenericPoint(@PathVariable int idGenericPoint) {
        //return new GenericGeoPoint(1,"Building 1","description1","images/image1","icons/icon1", -98.131233,120.23454,(short)1,"email1@gmail.com");
        Optional<GenericGeoPoint> genericPoint = serviceGenericGeoPoint.findById(idGenericPoint);
        if (!genericPoint.isPresent()) {
            throw new RuntimeException("Generic point not found");
        }
        return genericPoint.get();
    }

    @GetMapping("/all-generic-geo-point")
    public List<GenericGeoPoint> retrieveAllGenericPoints() {
        return serviceGenericGeoPoint.retrieveAllGenericGeoPoints();
    }

    @PostMapping("/generic-geo-point")
    public ResponseEntity createGenericPoint(@Valid @RequestBody GenericGeoPoint genericGeoPoint) {
        GenericGeoPoint modelSaved = serviceGenericGeoPoint.createGenericGeoPoint(genericGeoPoint);
        URI located = ServletUriComponentsBuilder.fromCurrentRequest().path(uriResource)
                .buildAndExpand(modelSaved.getId()).toUri();

        return ResponseEntity.created(located).build();

    }

    @PutMapping("/generic-geo-point")
    public ResponseEntity updateGenericPoint(@Valid @RequestBody GenericGeoPoint genericGeoPoint) {
        serviceGenericGeoPoint.updateGenericGeoPoint(genericGeoPoint);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/generic-geo-point/{idGenericGeoPoint}")
    public ResponseEntity deleteGenericPoint(@PathVariable int idGenericGeoPoint) {
        serviceGenericGeoPoint.deleteGenericGeoPoint(idGenericGeoPoint);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
