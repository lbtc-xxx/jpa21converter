package jpa21converter.business;

import jpa21converter.entity.MyCompositeKeyEmbeddable;
import jpa21converter.entity.MyCompositeKeyTable;
import jpa21converter.entity.MySimpleTable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
@LocalBean
public class MyEjb {

    @PersistenceContext
    private EntityManager em;

    public void saveMySimpleTable() {
        MySimpleTable mySimpleTable = new MySimpleTable();
        mySimpleTable.setSomeLocalDate(LocalDate.now());
        mySimpleTable.setSomeLocalDateTime(LocalDateTime.now());
        em.persist(mySimpleTable);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<MySimpleTable> fetchMySimpleTable() {
        return em.createQuery("select m from MySimpleTable m order by m.id desc", MySimpleTable.class)
                .setMaxResults(5)
                .getResultList();
    }

    public void saveMyCompositeKeyTable() {
        MyCompositeKeyTable myCompositeKeyTable = new MyCompositeKeyTable();
        MyCompositeKeyEmbeddable myCompositeKeyEmbeddable = new MyCompositeKeyEmbeddable();
        myCompositeKeyTable.setKey(myCompositeKeyEmbeddable);

        myCompositeKeyEmbeddable.setSomeLocalDateTime(LocalDateTime.now());
        myCompositeKeyEmbeddable.setSomeLocalDate(LocalDate.now());

        em.persist(myCompositeKeyTable);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<MyCompositeKeyTable> fetchMyCompositeKeyTable() {
        return em.createQuery("select m from MyCompositeKeyTable m" +
                " order by m.key.someLocalDate desc," +
                "m.key.someLocalDateTime desc", MyCompositeKeyTable.class)
                .setMaxResults(5)
                .getResultList();
    }
}
