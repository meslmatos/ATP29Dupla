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
                    exibeCrud(sc, cc);
                    break;
                case 2:
                    System.out.println("PRODUTO");
                    exibeCrud(sc, pc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while(opc != 0);
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
        System.out.println("1-Cadastrar \t 2-Listar \t 3-Excluir \t 4-Atualizar");
        int opcao = lerOpcao(sc);
        if(controlador instanceof ProdutoController){
            ProdutoController pc = (ProdutoController)controlador;
            Produto p = new Produto();
            switch(opcao){
                case 1:
                    System.out.print("Informe o id: ");
                    p.id = Integer.parseInt(sc.nextLine());
                    System.out.print("Informe o nome: ");
                    p.nome = sc.nextLine();
                    System.out.print("Informe o valor: ");
                    p.valor = Double.parseDouble(sc.nextLine());
                    Categoria c = new Categoria();
                    System.out.print("Informe o id da categoria: ");
                    c.id = Integer.parseInt(sc.nextLine());
                    System.out.print("Informe o nome da categoria: ");
                    c.nome = sc.nextLine();
                    System.out.print("Informe a descricao da categoria: ");
                    c.descricao = sc.nextLine();
                    p.categoria = c;
                    cadastrar(p, pc);
                    System.out.println("PRODUTO CADASTRADO!");
                break;
                case 2:
                    System.out.println("LISTAGEM DE PRODUTOS");
                    listar(pc);
                break;
                case 3:             
                    System.out.print("Informe o id do produto que quer excluir:");
                    p.id = Integer.parseInt(sc.nextLine());
                    excluir(p , pc);
                    System.out.println("PRODUTO EXCLUIDO!");
                break;
                case 4:
                    System.out.print("Informe o id a ser atualizado: ");
                    p.id = Integer.parseInt(sc.nextLine());
                    System.out.print("Informe o nome a ser atualizado: ");
                    p.nome = sc.nextLine();
                    System.out.print("Informe o valor a ser atualizado: ");
                    p.valor = Double.parseDouble(sc.nextLine());
                    System.out.print("Informe o id da categoria a ser atualizado: ");
                    p.categoria.id = Integer.parseInt(sc.nextLine());
                    System.out.print("Informe o nome da categoria a ser atualizado: ");
                    p.categoria.nome = sc.nextLine();
                    System.out.print("Informe a descricao da categoria a ser atualizado: ");
                    p.categoria.descricao = sc.nextLine();
                    atualizar(p, pc);
                    System.out.println("PRODUTO ATUALIZADO!");
            }
        } else if(controlador instanceof CategoriaController){
            CategoriaController cc = (CategoriaController)controlador;
            Categoria c = new Categoria();
            switch(opcao){
                case 1:
                    System.out.print("Informe o id da categoria: ");
                    c.id = Integer.parseInt(sc.nextLine());
                    System.out.print("Informe o nome da categoria: ");
                    c.nome = sc.nextLine();
                    System.out.print("Informe a descricao da categoria: ");
                    c.descricao = sc.nextLine();
                    cadastrar(c, cc);
                    System.out.println("CATEGORIA CADASTRADA!");
                break;
                case 2:
                    System.out.println("LISTAGEM DE CATEGORIAS");
                    listar(cc);
                break;
                case 3:             
                    System.out.print("Informe o id do categoria que quer excluir:");
                    c.id = Integer.parseInt(sc.nextLine());
                    excluir(c , cc);
                    System.out.println("CATEGORIA EXCLUIDA!");
                break;
                case 4:
                    System.out.print("Informe o id da categoria a ser atualizado: ");
                    c.id = Integer.parseInt(sc.nextLine());
                    System.out.print("Informe o nome da categoria a ser atualizado: ");
                    c.nome = sc.nextLine();
                    System.out.print("Informe a descricao da categoria a ser atualizado: ");
                    c.descricao = sc.nextLine();
                    atualizar(c, cc);
                    System.out.println("CATEGORIA ATUALIZADA!");
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
