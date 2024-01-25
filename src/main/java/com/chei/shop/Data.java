package com.chei.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Data {
    @Autowired
    public Shop shop;
    public void values(){
        int data;
        data=Integer.parseInt(shop.getContact().get("pageSize"));
        System.out.println(data);
    }
}
