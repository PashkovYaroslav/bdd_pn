package com.epam.pashkov.entities;

/**
 * User: Yaroslav_Pashkov
 * Date: 28.10.2015
 * Time: 12:27
 */
public class Manufacture {
    private String name;
    private int productCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Manufacture(String name, int productCount) {
        this.name = name;
        this.productCount = productCount;
    }
}
