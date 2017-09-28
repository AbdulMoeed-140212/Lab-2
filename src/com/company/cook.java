package com.company;
import java.util.ArrayList;
import java.util.Queue;
public class cook {
    private String name;
    private int freeAt;

    public cook(String name) {
        this.name = name;
        this.freeAt = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFreeAt() {
        return freeAt;
    }

    public void setFreeAt(int freeAt) {
        this.freeAt = freeAt;
    }
}
