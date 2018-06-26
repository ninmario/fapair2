/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import javax.swing.JPanel;

/**
 *
 * @author hfpma
 */
public class changePane {
    public static void change (JPanel m, JPanel s){
        m.removeAll();
        m.repaint();
        m.revalidate();
        m.add(s);
        m.repaint();
        m.revalidate();
    }
}
