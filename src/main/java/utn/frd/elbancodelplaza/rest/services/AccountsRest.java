package utn.frd.elbancodelplaza.rest.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.elbancodelplaza.entity.Accounts;
import utn.frd.elbancodelplaza.sessions.AccountsFacade;

/**
 *
 * @author Sergio
 */
@Path("/accounts")
public class AccountsRest {
    @EJB
    private AccountsFacade ejbAccountsFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Accounts> findAll(){
        return ejbAccountsFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Accounts accounts){
        ejbAccountsFacade.create(accounts);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Accounts accounts){
        ejbAccountsFacade.edit(accounts);
    }
    
    //eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")long id){
        ejbAccountsFacade.remove( ejbAccountsFacade.find(id) );
    }
    
    //obtener una entidad por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Accounts findById(@PathParam("id")long id){
        return ejbAccountsFacade.find(id);
    }
}

