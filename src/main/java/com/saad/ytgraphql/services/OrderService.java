package com.saad.ytgraphql.services;

import com.saad.ytgraphql.model.Order;
import com.saad.ytgraphql.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    public Order getOrderById(int orderId){
        Order order= orderRepo.findById(orderId).orElseThrow(()-> new RuntimeException("Order not found"));
        return order;
    }

    public boolean deleteOrder(int orderId){
        Order order= orderRepo.findById(orderId).orElseThrow(()-> new RuntimeException("Order not found"));
        orderRepo.delete(order);
        return true;
    }


}
