package modells;
public class Produto extends Base{
    public String nome;
    public double valor;
    public Categoria categoria;

    @Override
    public String toString() {
        return super.toString()+ "\nNome: "+ this.nome + "\nValor: "+ this.valor+ "\nCategoria\n"+ this.categoria+"\n";
    }
}