package com.chei.shop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component("spring")
@Data
@ConfigurationProperties(prefix = "man")
@Validated
public class Shop {
   private int pageSize;
   private Map<String,String> contact;
   private List<String>branches;



}