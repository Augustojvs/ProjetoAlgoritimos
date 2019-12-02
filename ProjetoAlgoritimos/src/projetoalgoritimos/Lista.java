package projetoalgoritimos;

import javax.swing.JOptionPane;

public class Lista {

    private Tipono primeiro, ultimo, posAtual;

    public Lista() {
        primeiro = ultimo = null;
    }

    public boolean vazia() {
        return primeiro == null;
    }

    public void inserirNoInicio(String nome, int codigo, String endereco) {
        Tipono no = new Tipono(nome, codigo, endereco);
        no.proximo = primeiro;
        if (vazia()) {
            ultimo = no;
        } else {
            primeiro.anterior = no;
        }
        JOptionPane.showMessageDialog(null, "Cliente Inserido com Sucesso!");
        primeiro = no;
        //this.imprimir();
    }

    public void inserirNoFim(String nome, int codigo, String endereco) {
        Tipono no = new Tipono(nome, codigo, endereco);
        if (vazia()) {
            primeiro = no;
        } else {
            no.anterior = ultimo;
            ultimo.proximo = no;
        }
        JOptionPane.showMessageDialog(null, "Cliente Inserido com Sucesso!");
        ultimo = no;
    }

    public void inserirOrdenado(String nome, int codigo, String endereco) {
        Tipono aux, ant, no;
        no = new Tipono(nome, codigo, endereco);
        aux = primeiro;
        ant = ultimo;
        while ((aux != null) && aux.item.getCodigo() < codigo) {
            ant = aux;
            aux = aux.proximo;
        }
        if (ant == null) {
            primeiro = no;
        } else {
            ant.proximo = no;
            no.proximo = aux;
        }
        if (aux == null) {
            ultimo = no;
        }

    }
    
    public Cliente localizarItem(String str) {
        int length = str.length();
        boolean buscaCodigo = true;
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return null;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                buscaCodigo = false;
            }
        }
        if(buscaCodigo){
            return buscarCliente(Integer.parseInt(str));
        } else {
            return buscarCliente(str);
        }
    }
    
    public Cliente buscarCliente(int codigo) {
        System.out.println("buscando código");
        if(primeiro == null){
            return null;
        }
        Tipono aux = primeiro;
        while(aux.item.getCodigo() != codigo){
            if (aux == ultimo) {
                return null;
            }
            aux = aux.proximo;
        }
        posAtual = aux;
        
        return posAtual.item;
    }
    
    public Cliente buscarCliente(String nome) {
        System.out.println("buscando nome");
        if(primeiro == null){
            return null;
        }
        Tipono aux = primeiro;
        while(!aux.item.getNome().equalsIgnoreCase(nome)){
            if (aux == ultimo) {
                return null;
            }
            aux = aux.proximo;
        }
        posAtual = aux;
        
        return posAtual.item;
    }

    public Cliente primeiro() {
        posAtual = primeiro;
        return posAtual.item;
    }

    public Cliente ultimo() {
        posAtual = ultimo;
        return posAtual.item;
    }

    public Cliente proximo() {
        if (posAtual == ultimo) {
            return null;
        }
        posAtual = posAtual.proximo;
        return posAtual.item;
    }

    public Cliente anterior() {
        if (posAtual == primeiro) {
            return null;
        }
        posAtual = posAtual.anterior;
        return posAtual.item;
    }

    public Cliente posicaoAtual() {

        return posAtual.item;
    }
    
    public Cliente getProximo(){
        if(posAtual.proximo == null){
            return null;
        }
        return posAtual.proximo.item;
    }
    public Cliente getAnterior(){
        if(posAtual.anterior == null){
            return null;
        }
        return posAtual.anterior.item;
    }
    
    public Cliente excluir(){
        Tipono aux = primeiro;
        while(aux.item.getCodigo() != posAtual.getCodigo()){
            aux = aux.proximo;
        }
        if (aux == primeiro) {
            primeiro = aux.proximo;
            if (aux == ultimo) {
                ultimo = null;
            }
        }else if (aux == ultimo) {
            ultimo = aux.anterior;
            ultimo.proximo = null;
        }else{
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
        }
        return aux.item;
    }

    void imprimir() {
        if (vazia()) {
            System.out.println("Lista vazia");
        } else {
            Tipono aux = primeiro;
            while (aux != null) {
                System.out.println("Produtos: " + aux);
                aux = aux.proximo;
            }
        }
    }
    
    void esvaziar() {
        primeiro = ultimo = null;
    }

    void exportarLista() {
        Arquivo a = new Arquivo("file.txt");
        a.abrirArquivo();
        if (vazia()) {
            System.out.println("Lista vazia");
        } else {
            Tipono aux = primeiro;
            while (aux != null) {
                a.gravarCliente(aux.getCodigo(),aux.getNome(), aux.getEndereco());
                aux = aux.proximo;
            }
            a.fecharArquivo();
        }
        JOptionPane.showMessageDialog(null, "Lista exportada com sucesso!");
    }

    void importarLista() {
        Arquivo a = new Arquivo("file.txt");
        a.openFile();
        a.lerRegistros(this);
        a.closeFile();
        JOptionPane.showMessageDialog(null, "Lista importada com sucesso!");
    }
}
