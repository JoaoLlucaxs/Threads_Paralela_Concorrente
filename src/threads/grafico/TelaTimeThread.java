/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads.grafico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    
    public TelaTimeThread(){
        setTitle("Minha tela para Threads");
        setSize(new Dimension(240,240));
        setLocationRelativeTo(null);
        setResizable(false);
        
        GridBagConstraints bagConstraints=new GridBagConstraints(); // controlador de posicionamento de componentes
        bagConstraints.gridx=0;
        bagConstraints.gridy=0;
        
        descricaoHora.setPreferredSize(new Dimension(200,25));
        jPanel.add(descricaoHora, bagConstraints);
        
        mostraTempo.setPreferredSize(new Dimension(200,25));
        bagConstraints.gridy ++;
        jPanel.add(mostraTempo,bagConstraints);
        
        
        descricaoHora2.setPreferredSize(new Dimension(200,25));
        bagConstraints.gridy ++;
        jPanel.add(descricaoHora2,bagConstraints);
        
        mostraTempo2.setPreferredSize(new Dimension(200,25));
       bagConstraints.gridy ++;
       jPanel.add(mostraTempo2,bagConstraints);
        
        add(jPanel,BorderLayout.WEST);
        // sempre será o último comando
        setVisible(true); // torna a tela visivel para usuário
    }
}
