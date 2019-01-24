/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import javax.swing.JFrame;

/**
 *
 * @author joao
 */
public class JogoDaVelha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JJogoDaVelha jogo = new JJogoDaVelha();
	jogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//evento de close
        jogo.setLocationRelativeTo(null);//Abrindo Centro da tela
	jogo.setVisible(true);
    }
    
}
