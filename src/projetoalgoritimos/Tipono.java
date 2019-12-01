package projetoalgoritimos;

public class Tipono {

    Cliente item;
    Tipono proximo;
    Tipono anterior;
    Tipono posAtual;

    public Tipono(String nome, int codigo, String endereco) {
        item = new Cliente(nome, codigo, endereco);
        proximo = anterior = null;
    }

    @Override
    public String toString() {
        return item.toString();
    }

    public int getCodigo() {
        return item.getCodigo();
    }

    public String getNome() {
        return item.getNome();
    }

    public String getEndereco() {
        return item.getEndereco();
    }

}
