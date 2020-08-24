package com.repository;

import com.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public Order findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[]{
                        id
                },
                new BeanPropertyRowMapper<Order>(Order.class));
    }


    class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setCustomerName(rs.getString("customerName"));
            order.setOrderDate(rs.getDate("orderDate"));
            order.setShippingAddress(rs.getString("shippingAddress"));
            order.setTotalAmt(rs.getInt("totalAmt"));
            return order;
        }
    }

    @Override
    public <S extends Order> S save(S s) {
        Order order = s;
        jdbcTemplate.update("INSERT INTO Order() VALUES(?,?,?,?)", order.getCustomerName(),
                order.getOrderDate(), order.getShippingAddress(), order.getTotalAmt());
        return (S) order;
    }

    @Override
    @Transactional
    public <S extends Order> Iterable<S> saveAll(Iterable<S> iterable) {
        List<Order> list = new ArrayList<>();
        iterable.forEach(order -> {
            jdbcTemplate.update("INSERT INTO Order() VALUES(?,?)", order.getCustomerName(),
                    order.getOrderDate(), order.getShippingAddress(), order.getTotalAmt());
            list.add(order);
        });
        return (Iterable<S>) list;
    }

    @Override
    public Optional<Order> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query("select * from order", new OrderRowMapper());
    }

    @Override
    public Iterable<Order> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Order order) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}

