package com.ozlem.listexample;

import android.widget.Toast;

import java.util.List;

public class Product {
    String productName;
    int quantity;
    int id;

    public Product() {

    }
    public Product(String productName,int quantity) {
        if(productName.length()>=2){
        this.productName = productName;
        }
        else{
            //Toast.makeText(MainActivity.class, "Gireceğiniz Ürün Adı en az 2 karakter olmalıdır...", Toast.LENGTH_SHORT).show();
        }
    }

    //getter and setter:

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
