/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author queir
 */
public class ImplementacaoFilaThreadpart2 extends Thread{
    
    // será static para ser unica
    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_filha= new ConcurrentLinkedQueue<ObjetoFilaThread>();
    
    public static void add(ObjetoFilaThread objetoFilaThread){
        pilha_filha.add(objetoFilaThread);
    }

    @Override
    public void run() {
        Iterator iteracao=pilha_filha.iterator();
        
        synchronized (iteracao) { // bloquear o acesso a essa lista por outros processos, importante para outras threads não entre e atrapalhe tudo
             // Enquanto tiver dados
        while(iteracao.hasNext()){
            ObjetoFilaThread processador=(ObjetoFilaThread) iteracao.next(); // pega o objeto atual
            
            //********** Processa o que tiver que processar aqui *********
            // Exemplo : processar 10 mil notas fiscais
            // Gerar uma lista enorme de PDF
            //Gerar um envio em massa de e-mail
            System.out.println(processador.getNome());
             System.out.println(processador.getEmail());
            // É aqui que iria chamar esses processos demorados e pesados
            
            iteracao.remove(); // em seguida remove e parte para o próximo
            
            try {
                Thread.sleep(100); // antes de partir para o próximo , da um tempo para descarga de memória
            } catch (InterruptedException ex) {
                Logger.getLogger(ImplementacaoFilaThreadpart2.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
        }
       
        
        try {
            Thread.sleep(100); // processou toda lista, da um tempo para descarga limpeza de memória
        } catch (InterruptedException ex) {
            Logger.getLogger(ImplementacaoFilaThreadpart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
