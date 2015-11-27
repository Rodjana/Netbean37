/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author TMN
 */
@Stateless
public class AdvisorFacade extends AbstractFacade<Advisor> {

    @PersistenceContext(unitName = "giftPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdvisorFacade() {
        super(Advisor.class);
    }
    
}
