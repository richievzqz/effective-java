package com.elrichpy.item5;

import java.util.function.Supplier;

public class DependencyInjection<T> {
    private final Supplier<? extends T> FACTORY;

    public DependencyInjection(Supplier<? extends T> factory) {
        this.FACTORY = factory;
    }

    public T produce() {
        return FACTORY.get();
    }
}
