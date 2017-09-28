package com.company;
public class food {
    private String name;
    private float cost;
    private int time;
    private int startTime;
    private int endTime;
    private int quantity;

    public food(String name, float cost, int time, int startTime, int endTime, int quantity) {
        this.name = name;
        this.cost = cost;
        this.time = time;
        this.startTime = startTime;
        this.endTime = endTime;
        this.quantity = quantity;
    }

    public food(){
        name ="";
        cost =0;
        quantity = 0;
        time = 0;
        startTime = 0;
        endTime =0;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
        if(this.time != 0)
            this.setEndTime(startTime+this.time);
    }



    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
