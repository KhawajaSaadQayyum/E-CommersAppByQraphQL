package com.saad.ytgraphql.controllers;

import com.saad.ytgraphql.model.Order;
import com.saad.ytgraphql.model.User;
import com.saad.ytgraphql.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @MutationMapping
    private Order createOrder(@Argument String orderDetails, @Argument String address, @Argument int price,@Argument int userId) {
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        order.setOrderId(userId);

        return orderService.createOrder(order);
    }
    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }
    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrder();
    }
    @QueryMapping
    public Order getOrder(@Argument int orderID){
        return orderService.getOrderById(orderID);
    }

}
