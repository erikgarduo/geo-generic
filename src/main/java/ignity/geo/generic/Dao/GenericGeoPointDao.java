package ignity.geo.generic.Dao;

import ignity.geo.generic.Model.Database.GenericGeoPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericGeoPointDao extends JpaRepository<GenericGeoPoint,Integer>{

}