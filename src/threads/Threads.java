/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threads;

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
        
        for(int i=0; i<=10; i++){
            // Quero executar esse envio, com tempo de parada, ou com um tempo determinado
            // Exemplo uma rotina de software "Executar a cada 5 min, segundos"
            
            // já foi muito utilizado para coisas pesadas, gerações de pdf, dando tempo para o proprio sistema operacional esvaziar a memoria e voltar a fazer a geração
            Thread.sleep(1000); // ele causa um tempo ou seja uma parada (para 1 segundo) de execução para cada for
            System.out.println("Executando alguma rotina, exemplo envio de email");
        }
    }
    //====================================== LOGICA ================================================================
    // primeiro ele espera depois ele da o "Executando alguma rotina, exemplo envio de email"
    // colocando ele DEPOIS do system.out -> primeiro executa "Executando alguma rotina, exemplo envio de email" depois espera 1 segundo...
}
