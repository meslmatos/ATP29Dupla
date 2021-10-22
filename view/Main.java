package view;

import java.util.Scanner;

import controllers.CategoriaController;
import controllers.ProdutoController;
import modells.Categoria;
import modells.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        cadastrar(p1, pc);
        cadastrar(c1, cc);

        Produto p2 = new Produto();
        p2.id = 2;
        p2.nome = "TV";
        p2.valor = 2889.98;
        p2.categoria = c1;
        cadastrar(p2, pc);
     
        listar(cc);
        listar(pc);

        p2.nome = "Ar-Condicionado";
        p2.valor = 3450.34;

        atualizar(p2, pc);
        listar(pc);
        
        Categoria c2 = new Categoria();
        c2.id = 2;
        c2.nome = "Eletrodomésticos";
        c2.descricao = "hudhushsishus";
        cadastrar(c2, cc);

        excluir(c1, cc);
        excluir(p2, pc);
        
        listar(cc);
        listar(pc);
    }

    public static void menu(){
        System.out.println("SISTEMA DE CADASTRO");
        System.out.println("1 - CATEGORIAS \t2-PRODUTOS");
    }

    public static int lerOpcao(Scanner sc){
        System.out.println("Escolha a opcao:");
        int opcao = Integer.parseInt(sc.nextLine());
        return opcao;
    }

    public static void cadastrar(Object obj, Object controlador){
        if(obj instanceof Produto){
            Produto p = (Produto) obj;
            ProdutoController pc = (ProdutoController) controlador;

            pc.create(p);
        } else if(obj instanceof Categoria){
            Categoria c = (Categoria) obj;
            CategoriaController cc = (CategoriaController) controlador;

            cc.create(c);
        }
    }

    public static void atualizar(Object obj, Object controlador){
        if(obj instanceof Produto){
            Produto p = (Produto) obj;
            ProdutoController pc = (ProdutoController) controlador;

            pc.update(p);
        } else if(obj instanceof Categoria){
            Categoria c = (Categoria) obj;
            CategoriaController cc = (CategoriaController) controlador;

            cc.update(c);
        }
    }

    public static void excluir(Object obj, Object controlador){
        if(obj instanceof Produto){
            Produto p = (Produto) obj;
            ProdutoController pc = (ProdutoController) controlador;

            pc.delete(p);
        } else if(obj instanceof Categoria){
            Categoria c = (Categoria) obj;
            CategoriaController cc = (CategoriaController) controlador;

            cc.delete(c);
        }
    }

    public static void listar(Object controlador){
        if(controlador instanceof ProdutoController){
            ProdutoController pc = (ProdutoController) controlador;

            for (Produto p : pc.read()) {
                System.out.println(p);
            }
        } else if(controlador instanceof CategoriaController){
            CategoriaController cc = (CategoriaController) controlador;

            for (Categoria c : cc.read()) {
                System.out.println(c);
            }
        }
    }
}
