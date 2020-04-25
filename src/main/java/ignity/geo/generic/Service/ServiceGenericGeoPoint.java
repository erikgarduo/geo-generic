package ignity.geo.generic.Service;

import ignity.geo.generic.Dao.GenericGeoPointDao;
import ignity.geo.generic.Model.Database.GenericGeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceGenericGeoPoint {

    @Autowired
    GenericGeoPointDao genericGeoPointDao;

    public Optional<GenericGeoPoint> findById(final int idGenericGeoPoint){
        return genericGeoPointDao.findById(idGenericGeoPoint);
    }

    public List<GenericGeoPoint> retrieveAllGenericGeoPoints(){
        return genericGeoPointDao.findAll();
    }

    public GenericGeoPoint createGenericGeoPoint(GenericGeoPoint genericPoint) {
        return genericGeoPointDao.save(genericPoint);
    }

    public GenericGeoPoint updateGenericGeoPoint(GenericGeoPoint any) {
        return genericGeoPointDao.save(any);
    }

    public void deleteGenericGeoPoint(int idGenericGeoPoint) {
        genericGeoPointDao.deleteById(idGenericGeoPoint);
    }
}
