/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.elbancodelplaza.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frd.elbancodelplaza.entity.Bonds;

/**
 *
 * @author pmari
 */
@Stateless
public class BondsFacade extends AbstractFacade<Bonds> {

    @PersistenceContext(unitName = "utn.frd_elbancodelplaza_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BondsFacade() {
        super(Bonds.class);
    }
    
}
