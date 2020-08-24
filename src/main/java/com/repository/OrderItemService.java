package com.repository;

import com.pojo.Order;
import com.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService implements OrderItemRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public OrderItem findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[]{
                        id
                },
                new BeanPropertyRowMapper<OrderItem>(OrderItem.class));
    }

    class OrderItemRowMapper implements RowMapper<OrderItem> {
        @Override
        public OrderItem mapRow(ResultSet rs, int rowNum) {
            OrderItem student = new OrderItem();
            return student;
        }
    }


    @Override
    public <S extends OrderItem> S save(S s) {
        OrderItem orderItem = s;
        jdbcTemplate.update("INSERT INTO OrderItem() VALUES(?,?,?)", orderItem.getProductCode(),
                orderItem.getProductName(), orderItem.getQty());
        return (S) orderItem;
    }

    @Override
    public <S extends OrderItem> Iterable<S> saveAll(Iterable<S> iterable) {
        List<OrderItem> list = new ArrayList<>();
        iterable.forEach(orderItem -> {
            jdbcTemplate.update("INSERT INTO OrderItem() VALUES(?,?,?)", orderItem.getProductCode(),
                    orderItem.getProductName(), orderItem.getQty());
            list.add(orderItem);
        });
        return (Iterable<S>) list;
    }

    @Override
    public Optional<OrderItem> findById(Integer integer) {
        return Optional.empty();
    }


    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<OrderItem> findAll() {
        return jdbcTemplate.query("select * from orderItem", new OrderItemRowMapper());
    }

    @Override
    public Iterable<OrderItem> findAllById(Iterable<Integer> iterable) {
        return null;
    }


    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(OrderItem orderItem) {

    }

    @Override
    public void deleteAll(Iterable<? extends OrderItem> iterable) {

    }


    @Override
    public void deleteAll() {

    }
}

