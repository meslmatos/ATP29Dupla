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
        
        int opc = 0;
        do{
            menu();
            opc = lerOpcao(sc);

            switch (opc) {
                case 1:
                    System.out.println("CATEGORIA");
                    break;
                case 2:
                    System.out.println("PRODUTO");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while(opc != 0);

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
        System.out.println("1 - CATEGORIAS \t2-PRODUTOS \t0-SAIR");
    }

    public static int lerOpcao(Scanner sc){
        System.out.println("Escolha a opcao:");
        int opcao = Integer.parseInt(sc.nextLine());
        return opcao;
    }

    public static void exibeCrud(Scanner sc, Object controlador){
        System.out.println("1-Cadastrar \t 2-Listar \t 3-Excluir \t Atualizar");
        int opcao = lerOpcao(sc);
        if(controlador instanceof Produto){
            ProdutoController pc = (ProdutoController)controlador;
            Produto p = new Produto();
            switch(opcao){
                case 1:
                    System.out.print("Indorme o id: ");
                    p.id = Integer.parseInt(sc.nextLine());
                    System.out.print("Informe o nome: ");
                    p.nome = sc.nextLine();
                    System.out.print("Informe o valor: ");
                    p.valor = Double.parseDouble(sc.nextLine());
                    System.out.print("Informe o id da categoria: ");
                    p.categoria.id = Integer.parseInt(sc.nextLine());
                    cadastrar(p, pc);
                break;
                case 2:
                    listar(pc);
                break;
                case 3:             
                    System.out.print("Informe o id do produto que quer excluir:");
                    p.id = Integer.parseInt(sc.nextLine());
                    excluir(p , pc);
                break;
            }
        }
      
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
