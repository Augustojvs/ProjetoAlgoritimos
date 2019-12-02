
package projetoalgoritimos;


public class Cliente {
    
    private int codigo;
    private String nome;
    private String endereco;
    private String categoria;
    
    
    public Cliente(){
    }
    
    public Cliente(String nome, int codigo, String endereco, String categoria)
    {
        this.codigo = codigo;
        this.nome  = nome;
        this.endereco = endereco;
        this.categoria = categoria;
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
        return getCodigo() + " " + getNome() + " " + getEndereco() + " " + getCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
