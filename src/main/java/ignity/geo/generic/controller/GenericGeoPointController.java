package ignity.geo.generic.controller;

import ignity.geo.generic.Model.Database.GenericGeoPoint;
import ignity.geo.generic.Service.ServiceGenericGeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenericGeoPointController {

    @Autowired
    private ServiceGenericGeoPoint serviceGenericGeoPoint;


    @GetMapping("/test")
    public GenericGeoPoint testBuilding(){
        return new GenericGeoPoint(1,"test Building 1","description1","images/image1","icons/icon1", -98.131233,120.23454, (short) 1,"email1@gmail.com");
    }

    @GetMapping("/generic-geo-point")
    public GenericGeoPoint retrieveOneGenericPoint(@RequestParam long idGenericPoint){
        return new GenericGeoPoint(1,"Building 1","description1","images/image1","icons/icon1", -98.131233,120.23454,(short)1,"email1@gmail.com");
    }

    @GetMapping("/all-generic-geo-point")
    public List<GenericGeoPoint> retrieveAllGenericPoints(){
        return serviceGenericGeoPoint.retrieveAllGenericGeoPoints();
    }

    @PostMapping("/generic-geo-point")
    public ResponseEntity createGenericPoint(@RequestBody GenericGeoPoint genericGeoPoint){
        return serviceGenericGeoPoint.createGenericGeoPoint(genericGeoPoint);
    }

    @PutMapping("/generic-geo-point/{idGenericGeoPoint}")
    public ResponseEntity updateGenericPoint(@RequestBody GenericGeoPoint genericGeoPoint,@PathVariable long idGenericPoint){
        return serviceGenericGeoPoint.updateGenericGeoPoint(genericGeoPoint);
    }

    @DeleteMapping("/generic-geo-point/{idGenericGeoPoint}")
    public ResponseEntity deleteGenericPoint(@PathVariable long idGenericGeoPoint){
        return serviceGenericGeoPoint.deleteGenericGeoPoint(idGenericGeoPoint);
    }
}
