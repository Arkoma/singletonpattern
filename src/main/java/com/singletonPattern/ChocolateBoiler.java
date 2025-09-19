package com.singletonPattern;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    private volatile static ChocolateBoiler instance;

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            synchronized (ChocolateBoiler.class) {
                if (instance == null) {
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // fill the boiler with milk/chocolate mixture
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring Contents to a boil
            boiled = true;
        }
    }

    private boolean isBoiled() {
        return boiled;
    }

    private boolean isEmpty() {
        return empty;
    }
}
