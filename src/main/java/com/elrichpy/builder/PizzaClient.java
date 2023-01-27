package com.elrichpy.builder;

import static com.elrichpy.builder.NyPizza.Size.SMALL;
import static com.elrichpy.builder.Pizza.Topping.*;

public class PizzaClient {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        DeepDish deepDish = new DeepDish.Builder()
                .filling("Spinach").addTopping(MUSHROOM).build();
    }
}
