package view;

import controllers.CategoriaController;
import controllers.ProdutoController;
import modells.Categoria;
import modells.Produto;

public class Main {
    public static void main(String[] args) {
        ProdutoController pc = new ProdutoController();
        CategoriaController cc = new CategoriaController();

        Categoria c1 = new Categoria();
        c1.id = 1;
        c1.nome = "Eletrônicos";
        c1.descricao = "blablablabla";

        Produto p1 = new Produto();
        p1.id = 1;
        p1.nome = "Celular";
        p1.valor = 1234.99;
        p1.categoria = c1;

        cc.create(c1);
        pc.create(p1);

        Produto p2 = new Produto();
        p2.id = 2;
        p2.nome = "TV";
        p2.valor = 2889.98;
        p2.categoria = c1;
        pc.create(p2);



        for (Categoria c : cc.read()) {
            System.out.println(c);            
        }

        for (Produto p : pc.read()) {
            System.out.println(p);           
        }

       
       p2.nome = "Ar-Condicionado";
       p2.valor = 3450.34;
       pc.update(p2);

       for (Produto p : pc.read()) {
        System.out.println(p);           
       }

       Categoria c2 = new Categoria();
       c2.id =2;
       c2.nome = "Eletrodomésticos";
       c2.descricao = "hudhushsishus";
       cc.create(c2);

       cc.delete(c1);
       pc.delete(p2);

       for (Categoria c : cc.read()) {
        System.out.println(c);            
       }

        for (Produto p : pc.read()) {
            System.out.println(p);           
        }

       


    }
}
