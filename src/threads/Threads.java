/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author queir
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        //Tempo de interrupção com Sleep
        
     //   for(int i=0; i<=10; i++){
            // Quero executar esse envio, com tempo de parada, ou com um tempo determinado
            // Exemplo uma rotina de software "Executar a cada 5 min, segundos"
            
            //System.out.println("Executando alguma rotina, exemplo envio de email");
            // já foi muito utilizado para coisas pesadas, gerações de pdf, dando tempo para o proprio sistema operacional esvaziar a memoria e voltar a fazer a geração
           // Thread.sleep(1000); // ele causa um tempo ou seja uma parada (para 1 segundo) de execução para cada for
        //}
    
       // System.out.println("CHEGOU AO FIM DO CODIGO DE THREAD");
        
        // Fluxo do sistema, cadastro de venda, emissão de nota fiscal..
       // JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");
        
    //====================================== LOGICA ================================================================
    // colocando ele DEPOIS do system.out -> primeiro executa "Executando alguma rotina, exemplo envio de email" depois espera 1 segundo...
    // neste exemplo estou simulando um sistema que ficaria travado devido o envio de e-mail , e isso para performance usuário não é bom
    //Então a seguir irei fazer um sistema em paralelo para que não atrapalhe o fluxo de um sistema, vai perceber que vai rodar e chamar muito rápido a caixinha Pane
    // e por trás vai ficar rondando o "Executando alguma rotina, exemplo envio de email" sem atrapalhar o fluxo do sistema
    
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
    
     //Fluxo do sistema, cadastro de venda, emissão de nota fiscal..
     JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");
    }
    
}
