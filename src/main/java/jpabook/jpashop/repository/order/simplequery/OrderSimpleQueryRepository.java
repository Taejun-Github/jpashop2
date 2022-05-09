package jpabook.jpashop.repository.order.simplequery;

import jpabook.jpashop.repository.OrderSimpleQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;
    public List<OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery(
                 "select new jpabook.jpashop.repository.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +
                        " from Order o" +
                        " join o.member m" +
                        " join o.delivery d", OrderSimpleQueryDto.class)
                .getResultList();
        // 쿼리로 엔티티가 아닌 Repository를 가져오므로 쿼리가 이렇게 복잡하게 나오는 것이다.
        // Entity를 Dto로 변환하는 방법이 더 낫고, 그게 안된다면 이것을 한다.
    }

}
