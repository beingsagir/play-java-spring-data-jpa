package repositories;

import models.users.UsersEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sagir on 07-05-2016.
 */

public interface UserRepositories extends CrudRepository<UsersEntity,String>
{

}
