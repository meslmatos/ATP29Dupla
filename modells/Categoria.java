package modells;

public class Categoria extends Base{
    public String nome;
    public String descricao;

    @Override
    public String toString() {
        return super.toString()+"\nNome: "+this.nome+ "\nDescrição: "+this.descricao+"\n";
    }
}
