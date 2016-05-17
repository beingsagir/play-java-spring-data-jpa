package controllers;

import models.users.UsersEntity;
import play.mvc.Result;
import repositories.UserRepositories;
import services.Counter;

import javax.inject.Inject;
import javax.inject.Singleton;

import static play.mvc.Results.ok;

/**
 * Created by Sagir on 17-05-2016.
 */

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class DbOperationController {

    @Inject
    private UserRepositories userRepositories;


    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */


    public Result index() {

        UsersEntity userEntity = new UsersEntity();
        userEntity.setId(1);
        userEntity.setEmail("sagir.sagir@gmail.com");
        userEntity.setPassword("secret");
        userRepositories.save(userEntity);
        return ok("Awesome Buddy ! You have saved me :D !! ");
    }
}
