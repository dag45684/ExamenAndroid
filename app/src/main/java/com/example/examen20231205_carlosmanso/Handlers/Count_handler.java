package com.example.examen20231205_carlosmanso.Handlers;

public class Count_handler {

    private final String count;

    public Count_handler(String s){
        this.count = s + " segundos";
    }

    public String getCount(){
        return count;
    }


}
