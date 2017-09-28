package com.company;

import java.util.ArrayList;
import java.time.*;
public class Order {
    public ArrayList<food> order= new ArrayList<food>();
    public int TotalCost;
    public int StartTime;
    public int ReadyTime;
    public int MaxTime;
    public boolean done ;
    public boolean TakeAway;
    public void calculateBill(){
        TotalCost = 0;
        for(food f: order){
            TotalCost += f.getCost() * f.getQuantity();
        }
    }

    public void setTime(){
        StartTime = LocalDateTime.now().getSecond();
    }
    public void calculateTime(){
        setTime();
        this.ReadyTime = 0;
        for(food f : order){
            this.ReadyTime += f.getTime();
        }
        done = false;
        MaxTime = StartTime+ ReadyTime;
    }
    public void print(){
        for(food f: order){
            System.out.println(f.getName() +" "+f.getCost()+" "+f.getQuantity()+ " "+ f.getTime());
        }
        System.out.println("Total Cost >>> "+ TotalCost);
        System.out.println("Total Time >>> "+ ReadyTime + "Min" );
    }
}
