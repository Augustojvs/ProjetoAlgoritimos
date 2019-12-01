
package projetoalgoritimos;


public class Cliente {
    
    public int codigo;
    private String nome;
    private String endereco;
    
    
    public Cliente(){
    }
    
    public Cliente(String nome, int codigo, String endereco)
    {
        this.codigo = codigo;
        this.nome  = nome;
        this.endereco = endereco;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
     public String toString()
    {
        return getCodigo() + " " + getNome() + " " + getEndereco();
    }
    /*
    public String toString()
    {
        return "Código: " + getCodigo() + " - Nome: " + getNome() + " - Endereço: " + getEndereco();
    }*/
}
