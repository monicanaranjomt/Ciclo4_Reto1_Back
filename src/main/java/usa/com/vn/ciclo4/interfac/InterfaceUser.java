/**
 * Escrito el 20/11/2021
 */
package usa.com.vn.ciclo4.interfac;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import usa.com.vn.ciclo4.modelo.ModeloUser;

/**
 *
 * @author Viviana Naranjo
 */
public interface InterfaceUser extends CrudRepository<ModeloUser, Integer> {
    Optional<ModeloUser> findByEmail(String email);
    Optional<ModeloUser> findByEmailAndPassword(String email,String password);
    //Optional<User> findByName(String name);
}
