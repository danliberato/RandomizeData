/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author daan
 * ADVISE: This program requires a single file named "input.txt" at same 
 */
public class RandomData {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        String caminho = "./src/randomdata/";
        List dados = new ArrayList();
        
        try {
          FileReader arq = new FileReader(caminho + "input.txt");
          BufferedReader lerArq = new BufferedReader(arq);

          String linha = lerArq.readLine();
          while (linha != null) {
            dados.add(linha);

            linha = lerArq.readLine(); // lê da segunda até a última linha
          }

          arq.close();
        } catch (IOException e) {
            System.err.printf("ERROR: " + e.getMessage());
        }
        
        //randomiza os dados
        Collections.shuffle(dados);
        
        try{
            FileWriter saida = new FileWriter(caminho + "output.txt");
            PrintWriter gravarArq = new PrintWriter(saida);
            
            for(int i = 0;i < dados.size(); i++){
                gravarArq.println(dados.get(i));
            }
            gravarArq.flush();
            gravarArq.close();
        }catch(IOException e){
            e.getMessage();
        }
    }
    
}

