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
import utn.frd.elbancodelplaza.entity.Clients;
import utn.frd.elbancodelplaza.sessions.ClientsFacade;

/**
 *
 * @author Sergio
 */
@Path("/clients")
public class ClientsRest {
    @EJB
    private ClientsFacade ejbClientsFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Clients> findAll(){
        return ejbClientsFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Clients clients){
        ejbClientsFacade.create(clients);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Clients clients){
        ejbClientsFacade.edit(clients);
    }
    
    //eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")long id){
        ejbClientsFacade.remove( ejbClientsFacade.find(id) );
    }
    
    //obtener una entidad por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Clients findById(@PathParam("id")long id){
        return ejbClientsFacade.find(id);
    }
}