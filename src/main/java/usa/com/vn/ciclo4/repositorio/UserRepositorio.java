/**
 * Escrito el 20/11/2021
 */
package usa.com.vn.ciclo4.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.com.vn.ciclo4.interfac.InterfaceUser;
import usa.com.vn.ciclo4.modelo.ModeloUser;

/**
 *
 * @author Viviana Naranjo
 */
@Repository
public class UserRepositorio {
     @Autowired
    private InterfaceUser interfaceUser;

    public List<ModeloUser> getAll() {
        return (List<ModeloUser>) interfaceUser.findAll();
    }

    public Optional<ModeloUser> getUser(int id) {
        return interfaceUser.findById(id);
    }

    public ModeloUser save(ModeloUser user) {
        return interfaceUser.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<ModeloUser> usuario = interfaceUser.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<ModeloUser> autenticarUsuario(String email, String password) {
        return interfaceUser.findByEmailAndPassword(email, password);
    }
}
