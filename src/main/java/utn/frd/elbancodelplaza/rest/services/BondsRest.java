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
import utn.frd.elbancodelplaza.entity.Bonds;
import utn.frd.elbancodelplaza.sessions.BondsFacade;

/**
 *
 * @author Sergio
 */
@Path("/bonds")
public class BondsRest {
    @EJB
    private BondsFacade ejbBondsFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bonds> findAll(){
        return ejbBondsFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Bonds bonds){
        ejbBondsFacade.create(bonds);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Bonds bonds){
        ejbBondsFacade.edit(bonds);
    }
    
    //eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")long id){
        ejbBondsFacade.remove( ejbBondsFacade.find(id) );
    }
    
    //obtener una entidad por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Bonds findById(@PathParam("id")long id){
        return ejbBondsFacade.find(id);
    }
}
