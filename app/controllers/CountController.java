package controllers;

import models.users.NewTableEntity;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.UserRepositories;
import services.Counter;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class CountController extends Controller {

    @Inject
    private UserRepositories userRepositories;


    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */


    public Result index() {

        NewTableEntity userEntity = new NewTableEntity();
        userEntity.setId(1);
        userEntity.setEmail("sagir.sagir@gmail.com");
        userEntity.setPassword("secret");
        userRepositories.save(userEntity);
        return ok("Awesome Buddy ! You have saved me :D !! ");
    }
}
