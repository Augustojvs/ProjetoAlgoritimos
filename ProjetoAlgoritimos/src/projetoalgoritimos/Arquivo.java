/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoalgoritimos;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

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

    public void fecharArquivo() {
        saida.close();
    }

    public void lerRegistros() {
        try // Lê os registros no arquivo utilizado
        {
            Cliente c = new Cliente();
            System.out.format("%-10s%-12s%-12s\n", "Codigo", "Nome", "Endereço");

            while (entrada.hasNext()) {
                c.setCodigo(entrada.nextInt());
                c.setNome(entrada.next());
                c.setEndereco(entrada.next());
                System.out.format("%-10s%-12s%-12s\n", c.getCodigo(), c.getNome(), c.getEndereco());
            } // fim do while
        } // fim do try lê registros ...
        catch (Exception minhaExcecao) {
            System.err.println("Erro ao ler o arquivo\n" + minhaExcecao);
            System.exit(1);
        } // fim do catch
    }

    public void gravarCliente(String cliente) {
        saida.format("%s\n", cliente);
    }
}
