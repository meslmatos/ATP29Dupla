package controllers;

import java.util.ArrayList;

public class BaseController<T> {
    private ArrayList<T> dados;

    public BaseController(){
        this.dados = new ArrayList<T>();
    }

    public void create(T obj){
        if (!exist(obj)) {
            this.dados.add(obj);    
        }
    }
    
    public ArrayList<T> read(){
        return this.dados;
    }

    public void update(T obj){
        if(exist(obj)){
            this.delete(obj);
            this.create(obj);
        }
    }

    public void delete(T obj){
        this.dados.remove(obj);
    }

    public boolean exist(T obj){
        return this.dados.contains(obj);
    }
}