/**
 * Escrito el 20/11/2021
 */
package usa.com.vn.ciclo4.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.com.vn.ciclo4.modelo.ModeloUser;
import usa.com.vn.ciclo4.repositorio.UserRepositorio;

/**
 *
 * @author Viviana Naranjo
 */
@Service
public class UserServicio {
     @Autowired
     private UserRepositorio userRepositorio;
    
    public List<ModeloUser> getAll() {
        return userRepositorio.getAll();
    }

    public Optional<ModeloUser> getUser(int id) {
        return userRepositorio.getUser(id);
    }

    public ModeloUser registrar(ModeloUser user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepositorio.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepositorio.existeEmail(email);
    }

    public ModeloUser autenticarUsuario(String email, String password) {
        Optional<ModeloUser> usuario = userRepositorio.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new ModeloUser(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}

