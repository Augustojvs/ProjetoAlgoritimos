package projetoalgoritimos;


public class Lista {
    private Tipono primeiro, ultimo, anterior, proximo, posAtual;
    
    public Lista(){
        primeiro = ultimo = null;
    }
    public boolean vazia(){
        return primeiro == null;
    }
    public void inserirNoInicio(String nome, int codigo, String endereco){
        Tipono no = new Tipono(nome, codigo, endereco);
        no.proximo = primeiro;
        if (vazia()) {
            ultimo = no;
        }else{
            primeiro.anterior = no;
        }
        primeiro = no;
    }
    public void inserirNoFim(String nome, int codigo, String endereco){
        Tipono no = new Tipono(nome, codigo, endereco);
        if (vazia()) {
            primeiro = no;
        }else{
            no.anterior = ultimo;
            ultimo.proximo = no;
        }
        ultimo = no;
    }
    public void inserirOrdenado(String nome, int codigo, String endereco){
        Tipono aux, ant, no;
        no = new Tipono(nome, codigo, endereco);
        aux = primeiro;
        ant = ultimo;
        while ((aux != null) && aux.item.getCodigo() < codigo){
            ant = aux;
            aux = aux.proximo;
        }
        if (ant == null) {
            primeiro = no;
        }else{
            ant.proximo = no;
            no.proximo = aux;
        }
        if (aux == null) {
            ultimo = no;
        }
       
    }
    public Cliente primeiro()
    {
        posAtual = primeiro;
        return posAtual.item;
    }
    
    public Cliente ultimo()
    {
        if (vazia())
            return null;

        posAtual = ultimo ;
        return posAtual.item;
    }
    
    public Cliente proximo()
    {
        posAtual = posAtual.proximo;
        return posAtual.item;
    }
    
    public Cliente anterior()
    {
        posAtual = posAtual.anterior;
        return posAtual.item;
    }
    public Cliente posicaoAtual(){
        
        return posAtual.item;
    }
    
    void imprimir(){
        if(vazia()){
            System.out.println("Lista vazia");
        }else{
            Tipono aux = primeiro;
            while(aux != null){
                System.out.println("Produtos: " + aux);
                aux = aux.proximo;
            }
        }
    }
}
