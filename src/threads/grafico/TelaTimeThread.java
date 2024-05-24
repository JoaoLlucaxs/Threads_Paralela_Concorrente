/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads.grafico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author queir
 */
public class TelaTimeThread extends JDialog{
    
    private JPanel jPanel=new JPanel(new GridBagLayout()); // painel de componentes
    
    private JLabel descricaoHora=new  JLabel("Time Thread 1");
    private JTextField mostraTempo=new JTextField();
    
    private JLabel descricaoHora2=new  JLabel("Time Thread 2");
    private JTextField mostraTempo2=new JTextField();
    
    private JButton botaoStart=new JButton("Start");
    private JButton botaoStop=new JButton("Stop");
    
    
    // Criando Objeto para Thread
    private Runnable thread1=new Runnable() {
        @Override
        public void run() {
           // percorrer infinitamente a data e a hora no campo (atualizar a cada segundo a hora)
           while(true){ // fica sempre rodando
               mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:s").
                       format(Calendar.getInstance().getTime()));
               
               try {
                   Thread.sleep(1000);// dar pausa de 1 segundo, pois o while é mega rápido e corre risco de travar o computador
               } catch (InterruptedException ex) {
                   Logger.getLogger(TelaTimeThread.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    };
    
    //************************* Thread 2 Campo 2 **********************************************
     private Runnable thread2=new Runnable() {
        @Override
        public void run() {
           // percorrer infinitamente a data e a hora no campo (atualizar a cada segundo a hora)
           while(true){ // fica sempre rodando
               mostraTempo2.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:s").
                       format(Calendar.getInstance().getTime()));
               
               try {
                   Thread.sleep(1000);// dar pausa de 1 segundo, pois o while é mega rápido e corre risco de travar o computador
               } catch (InterruptedException ex) {
                   Logger.getLogger(TelaTimeThread.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    };
    
    private Thread threadTime;
    private Thread threadTime2;
    
    public TelaTimeThread(){
        setTitle("Minha tela para Threads");
        setSize(new Dimension(240,240));
        setLocationRelativeTo(null);
        setResizable(false);
        
        GridBagConstraints bagConstraints=new GridBagConstraints(); // controlador de posicionamento de componentes
        bagConstraints.gridx=0;
        bagConstraints.gridy=0;
        bagConstraints.gridwidth=2;
        bagConstraints.insets=new Insets(5, 10, 5, 5);
        bagConstraints.anchor=GridBagConstraints.WEST;
        
        descricaoHora.setPreferredSize(new Dimension(200,25));
        jPanel.add(descricaoHora, bagConstraints);
        
        mostraTempo.setPreferredSize(new Dimension(200,25));
        bagConstraints.gridy ++;
        mostraTempo.setEditable(false);
        jPanel.add(mostraTempo,bagConstraints);
        
        
        descricaoHora2.setPreferredSize(new Dimension(200,25));
        bagConstraints.gridy ++;
        jPanel.add(descricaoHora2,bagConstraints);
        
        mostraTempo2.setPreferredSize(new Dimension(200,25));
       bagConstraints.gridy ++;
       mostraTempo2.setEditable(false);
       jPanel.add(mostraTempo2,bagConstraints);
       
       bagConstraints.gridwidth=1;
       
       botaoStart.setPreferredSize(new Dimension(92,25));
       bagConstraints.gridy++;
       jPanel.add(botaoStart,bagConstraints);
       
       botaoStop.setPreferredSize(new Dimension(92,25));
       bagConstraints.gridx++;
       jPanel.add(botaoStop,bagConstraints);
              
       //********************** Adicionando o Evento no botão ************************************
       botaoStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // executa o clique no botão
                threadTime=new Thread(thread1);
                threadTime.start();
                
                threadTime2=new Thread(thread2);
                threadTime2.start();
                
                botaoStart.setEnabled(false);
                botaoStop.setEnabled(true);
            }
       });
       
       botaoStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              threadTime.stop();
              threadTime2.stop();
              
               botaoStart.setEnabled(true);
                botaoStop.setEnabled(false);
            }
       });
       
       // Ao abrir a telinha botão stopr desabilitado
       botaoStop.setEnabled(false);
       
        add(jPanel,BorderLayout.WEST);
        // sempre será o último comando
        setVisible(true); // torna a tela visivel para usuário
    }
}
