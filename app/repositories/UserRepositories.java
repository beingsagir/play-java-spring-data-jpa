package repositories;

import models.users.NewTableEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sagir on 07-05-2016.
 */

public interface UserRepositories extends CrudRepository<NewTableEntity,String>
{

}
