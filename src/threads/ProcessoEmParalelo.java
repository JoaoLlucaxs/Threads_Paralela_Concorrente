/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author queir
 */
public class ProcessoEmParalelo {
    public static void main(String[] args) {
        
        //Note que a nota fiscal dei tempo de 4000 -> elas rodam paralelamente, mas se uma thread demora mais que a outra
        //a outra vai assumindo e continua fazendo seu papel então pode ter exemplo: (4 - email , 2 -nota fiscal..)
        //Isso se da em processamento concorrente ,se uma thread está mais lenta que a outra, a outra entra e executa
        //ficam concorrendo por (memoria, processamento, tempo) , elas vão se gerenciando (processos pesados ocorre isso , mas depende da rotina, espaço em memória..)
        
        
        
        
        //Thread processamento paralelo do envio de e-mail
         new Thread(){
            
            public void run() { // executa o que nós queremos
               //aqui vai o código da rotina
                 for(int i=0; i<=10; i++){
            
            System.out.println("Executando alguma rotina, exemplo envio de email");
                     try {
                         Thread.sleep(1000); // ele causa um tempo ou seja uma parada (para 1 segundo) de execução para cada for
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                     }
        }
            }
        
    }.start(); // start -> liga a thread que fica processando paralelamente por trás dos panos
     
     
     // ******************************** DIVISÃO DAS THREADS ********************************************************
     
     // Envio de nota fiscal
      new Thread(){
            
            public void run() { // executa o que nós queremos
               //aqui vai o código da rotina
                 for(int i=0; i<=10; i++){
            
            System.out.println("Executando alguma rotina, envio de nota fiscal");
                     try {
                         Thread.sleep(4000); // ele causa um tempo ou seja uma parada (para 1 segundo) de execução para cada for
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                     }
        }
            }
        
        }.start(); // start -> liga a thread que fica processando paralelamente por trás dos panos
    }
}
