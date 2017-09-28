package com.company;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Time;
import java.util.*;
import java.time.*;

public class Main {
    private static ArrayList<food> menu = new ArrayList<food>();
    private static ArrayList<Order> allOrders = new ArrayList<Order>();
    private static LocalDateTime currentTime;
    private static cook []chef= new cook[4];

    public static void main(String[] args) {
        initalize();
        run();
    }

    static void initalize(){
        menu.add(new food("apetizer1" , 10 , 5 , 0,0,0));
        menu.add(new food("apetizer2" , 15 , 6 , 0,0,0));
        menu.add(new food("apetizer3" , 20 , 5 , 0,0,0));
        menu.add(new food("apetizer4" , 25 , 6 , 0,0,0));
        menu.add(new food("soup1"     , 15 , 5 , 0,0,0));
        menu.add(new food("soup2"     , 19 , 5 , 0,0,0));
        menu.add(new food("maincourse1" , 30 , 12, 0,0,0));
        menu.add(new food("maincourse2" , 40 , 13 , 0,0,0));
        menu.add(new food("maincourse3" , 50 , 11 , 0,0,0));
        menu.add(new food("maincourse4" , 60 , 12, 0,0,0));
        menu.add(new food("maincourse5" , 70 , 15 , 0,0,0));
        menu.add(new food("maincourse6" , 65 , 14, 0,0,0));
        menu.add(new food("sideOrders1" , 10 , 6 , 0,0,0));
        menu.add(new food("sideOrders2" , 8 , 7 , 0,0,0));
        menu.add(new food("sideOrders3" , 5 , 5 , 0,0,0));
        chef[0] = new cook("Chef1");
        chef[1] = new cook("Chef2");
        chef[2] = new cook("Chef3");
        chef[3] = new cook("Chef4");


    }
    static void run(){
        currentTime = LocalDateTime.now();
        Scanner in = new Scanner(System.in);
        boolean takeOrder = true;
        System.out.println("Welcome to cafe");
        int option;
        Order temp_order = new Order();
        // check if cafe is open
        while(currentTime.toLocalTime().getHour() >= 11 && currentTime.toLocalTime().getHour() <=22){
            System.out.println("Time : "+currentTime.toLocalTime());
            takeOrder = false;
            food item;
            System.out.println("Cafe Is open");
            System.out.print("Would to like to give order ? 1 = y / 2 = n ");
            int o = in.nextInt();
            if( o == 1)
                takeOrder = true;
            while(takeOrder) {
                item = new food();
                printMenu();
                System.out.print("Select an item >>>");
                option = in.nextInt();
                item = menu.get(option);
                System.out.println("Enter Quantity");
                item.setQuantity(in.nextInt());
                temp_order.order.add(item);
                System.out.println("Add another item 1 for yes/ 2 for no");
                if(in.nextInt() == 2){
                    takeOrder = false;
                }

            }
            // Take away  or delivery Selection
            System.out.println(" 1 for TakeAway or 2 for Delivery");
            if(in.nextInt() == 1){
                temp_order.TakeAway = true;
            }
            else{
                temp_order.TakeAway = false;
            }
            // calculate Bill
            temp_order.calculateBill();
            temp_order.calculateTime(); // calculate Time
            //temp_order.print();
            allOrders.add(temp_order);
            System.out.println("Order Taken");
            SetChef(temp_order); // update all chefs
            printPendingOrders();

        }
        System.out.println("Cafe Closed");
    }

    static void printMenu(){
        int index =1;
        for ( food f : menu){
            System.out.print(index + ". "+f.getName() + " : Rs "+ f.getCost() +"\t");
            if(index % 2 == 0){
                System.out.println("");
            }
            index++;
        }
        System.out.println("");
    }

    static void printPendingOrders(){
        int num = 0;
        for(Order o: allOrders){
            if(!o.done){
                num++;
            }
        }
        System.out.println("Pending ordes >>> " + num);
    }

    static void SetChef(Order o){
        int a = chef[0].getFreeAt();
        int freeChef =0;
        for(int i = 1 ; i <4 ;i++){
            if(chef[i].getFreeAt() < a){
                a= chef[i].getFreeAt();
                freeChef = i;
            }
        }
        if(chef[a].getFreeAt() == 0 ){
            chef[a].setFreeAt(LocalDateTime.now().getMinute());
        }
        chef[a].setFreeAt(chef[a].getFreeAt()+ o.ReadyTime);
    }
}
