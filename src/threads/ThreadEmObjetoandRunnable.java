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
public class ThreadEmObjetoandRunnable {
    //Neste exemplo irei organizar melhor as thread dos exemplos anteriores
    public static void main(String[] args) {
        
        // Passando para thread pelo construtor dela
        // Qual vantagem? -> agora temos o objeto da thread para manipular em qualquer lugar
        Thread email=  new Thread(thread1);
        email.start();
        
        Thread nota_Fiscal=new Thread(thread2);
        nota_Fiscal.start();
    }
   
    
    private static Runnable thread2 = new Runnable() {
        @Override
        public void run() {
             for(int i=0; i<=10; i++){
            
            System.out.println("Executando alguma rotina, nvio de NOTA FISCAL");
                     try {
                         Thread.sleep(4000); // ele causa um tempo ou seja uma parada (para 1 segundo) de execução para cada for
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                     }
            }
        }
    };
    
     private static Runnable thread1=new Runnable() {
        @Override
        public void run() {
              for(int i=0; i<=10; i++){
            
            System.out.println("Executando alguma rotina, exemplo envio de EMAIL");
                     try {
                         Thread.sleep(1000); // ele causa um tempo ou seja uma parada (para 1 segundo) de execução para cada for
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                     }
            }
        }
     };
}