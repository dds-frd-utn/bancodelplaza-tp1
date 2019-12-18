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
import utn.frd.elbancodelplaza.entity.Transactions;
import utn.frd.elbancodelplaza.sessions.TransactionsFacade;

/**
 *
 * @author Sergio
 */
@Path("/transactions")
public class TransactionsRest {
    @EJB
    private TransactionsFacade ejbTransactionsFacade;
    
    //obtener todas las entidades
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transactions> findAll(){
        return ejbTransactionsFacade.findAll();
    }
    
    //crear entidades
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Transactions transactions){
        ejbTransactionsFacade.create(transactions);
    }
    
    //actualizar entidades
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Transactions transactions){
        ejbTransactionsFacade.edit(transactions);
    }
    
    //eliminar entidades
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")long id){
        ejbTransactionsFacade.remove( ejbTransactionsFacade.find(id) );
    }
    
    //obtener una entidad por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Transactions findById(@PathParam("id")long id){
        return ejbTransactionsFacade.find(id);
    }
}