/**
 * Escrito el 20/11/2021
 */
package usa.com.vn.ciclo4.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.com.vn.ciclo4.modelo.ModeloUser;
import usa.com.vn.ciclo4.servicio.UserServicio;

/**
 *
 * @author Viviana Naranjo
 */

@RestController
/**
 * 
 */
@RequestMapping("/api/user")
@CrossOrigin("*")
/**
 * Metodo
 */
public class UserWeb {
    /**
     * 
     */
    @Autowired
/**
 * Metodo
 */
    private UserServicio userServicio;
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
 /**
 * Metodo
 */
    public List<ModeloUser> getAll() {
        return userServicio.getAll();
    }
    /**
     * 
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
 /**
 * Metodo
 */
    public ModeloUser registrar(@RequestBody ModeloUser user) {
        return userServicio.registrar(user);
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
/**
 * Metodo
 */
    public ModeloUser autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userServicio.autenticarUsuario(email, password);
    }
   /**
    * 
    * @param email
    * @return 
    */ 
    @GetMapping("/{email}")
/**
 * Metodo
 */
    public boolean existeEmail(@PathVariable("email") String email) {
        return userServicio.existeEmail(email);
    }   
}


