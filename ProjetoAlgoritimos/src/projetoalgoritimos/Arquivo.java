/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoalgoritimos;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Arquivo {

    String nomeArquivo;
    Formatter saida;
    Scanner entrada;

    public Arquivo(String n) {
        nomeArquivo = n;
    }

    public void openFile() {
        try {
            entrada = new Scanner(new File(nomeArquivo));
        } // fim do try
        catch (Exception minhaExcecao) {
            System.err.println("Erro ao tentar abrir o arquivo!");
            System.exit(1);
        }// fim do catch		
    }

    public void abrirArquivo() {
        try {
            saida = new Formatter(nomeArquivo);
        } // fim do try
        catch (Exception minhaExcecao) {
            System.err.println("Erro ao tentar abrir o arquivo!");
            System.exit(1);
        }// fim do catch		
    }
    
    public void closeFile() {
        entrada.close();
    }

    public void fecharArquivo() {
        saida.close();
    }

    public Cliente lerRegistros(Lista l) {
        try
        {
            l.esvaziar();
            while (entrada.hasNext()) {
                int codigo = entrada.nextInt();
                String nome = entrada.next();
                String end = entrada.next();
                String cat = entrada.next();
                l.inserirNoFim(nome,codigo,end,cat);
            }
            return l.primeiro();
        }
        catch (Exception minhaExcecao) {
            System.err.println("Erro ao ler o arquivo\n" + minhaExcecao);
            return null;
        }
    }

    public void gravarCliente(int codigo, String nome, String endereco, String categoria) {
        saida.format("%d %s %s %s\n", codigo, nome, endereco, categoria);
    }
}
