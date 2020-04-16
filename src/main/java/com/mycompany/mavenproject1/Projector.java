/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.concurrent.TimeUnit;
/**
 *
 * @author Ly Gia Hoang
 */
public class Projector {
       //properties:
    int ID;
    String model;
    float price;
    int warranty;
    String datesold;
    //methods:
        //default constructor:
    public Projector() 
    {
        ID=1;
        model="Sony";
        price=20000;
        warranty=24;
        datesold="25/09/2018";
    }
        //constructor with parameters
    public Projector(int ID, String model, float price, int warranty, String datesold) {
        this.ID = ID;
        this.model = model;
        this.price = price;
        this.warranty = warranty;
        this.datesold = datesold;
    }
//Output the Projector
   void Output(){ 
       System.out.println("ID:"+ID);
       System.out.println("model:"+model);
       System.out.println("price:" +price+ " Millions ");
       System.out.println("warranty:" +warranty+ " Months ");
       System.out.println("datesold:"+datesold);
   }
   //Write Expired
   String Expired() throws ParseException//bo qua truong hop ngoai le
   {
       Calendar a=Calendar.getInstance();// a la bien cua lich
       SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");//format
       Date d=formatter.parse(datesold);//format from String to date=
       a. setTime(d);//set Time of d
       a.add(Calendar.MONTH, warranty);//Addition months
       String expired=formatter.format(a.getTime());//format Expired from date to String
       return expired;
   }
   //write Compare
   int Compare(Projector B) throws ParseException
   {
       SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
       Date datesoldA= formatter.parse(this.datesold);//format datesoldA from String to Date
       Date datesoldB= formatter.parse(B.datesold);//format datesoldB from String to Date
       if (datesoldA.before(datesoldB)==true){
           return 1;
       }
       else if (datesoldA.after(datesoldB)==true){
           return -1;
       }
       return 0;
   }
   float MoneyMaintainance(String DateMaintainance) throws ParseException
   {
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        Date d1=format.parse(DateMaintainance);//format DateMaintainance from String to Date 
        Date d2=format.parse(this.Expired());//format ExpiredA from String to Date
        long i1=d1.getTime();//change DateMaintainance to miliseconds
        long i2=d2.getTime();//change DateMaintainance to miliseconds
        long m=i1-i2;//change
        m=m/(24*3600*1000);
        
        float MoneyMaintainance= (price*m)/100;
        
        return MoneyMaintainance;
 }
    // Group setter
    void setID(int newID) {
        this.ID = newID;
    }
    void setModel(String newModel){
        if(newModel.equalsIgnoreCase("Casio") || newModel.equalsIgnoreCase("HP") ||newModel.equalsIgnoreCase("ASUS")){
             this.model=newModel;
        }
    }
    void setPrice(float newPrice){
        if(newPrice>=1 && newPrice<=20){
             this.price=newPrice;
        }
    }
    void setWarranty(int newWarranty){
        this.warranty=newWarranty;
    }
    void setDateSold(String newDateSold){
        if(this.datesold.compareTo(newDateSold)>0){
            this.datesold=newDateSold;
        }
    }
    //Group getter
    int getID(){
        return ID;
    }
    String getModel(){
        return model;
    }
    float getPrice(){
        return price;
    }
    int getWarranty(){
        return warranty;
    }
    String getDateSold(){
        
       return datesold;
    }
   public static void main(String[] args) throws ParseException 
    {
        Projector A= new Projector(1,"Dell",10,12,"09/03/2018");
        A.Output();
        System.out.println("Expired: "+A.Expired());
        Projector B=new Projector(2, "HP", 15, 8, "13/02/2018");
        B.Output();
        System.out.println("Expired: "+B.Expired());
        switch(A.Compare(B)){
            case 1:{
                System.out.println("Date A sale before Date sale B");
                break;
            }
            case -1:{
                System.out.println("Date A sale after Date sale B");
                break;
            }
            case 0:{
                System.out.println("A and B sale in the same day");
                break;
            }   
        }
       String DateMaintainance="18/03/2019";
       if (A.MoneyMaintainance(DateMaintainance)>0){
           System.out.println("DateMaintainance:"+A.MoneyMaintainance(DateMaintainance));
       }
    }
}
