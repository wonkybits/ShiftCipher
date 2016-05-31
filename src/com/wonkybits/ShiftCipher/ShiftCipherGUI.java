package com.wonkybits.ShiftCipher;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.*;

/**
 * Created by upxs078 on 5/25/16.
 */
public class ShiftCipherGUI {
    // GUI components
    private JTextArea msgTextArea;
    private JTextField shiftTextField;
    private JButton enButton;
    private JTextPane outputPane;
    private JButton deButton;
    private JLabel shiftLabel;
    private JPanel mainPanel;

    private ShiftCipher sf;
    private int shift;
    private String msg;


    public ShiftCipherGUI() {

        sf = new ShiftCipher();
        shift = 0;
        msg = "";

        enButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEmpty(msgTextArea) && !isEmpty(shiftTextField)) {
                    shift = Integer.parseInt(shiftTextField.getText());
                    msg = msgTextArea.getText();
                    sf.setS(shift);
                    sf.setMessage(msg);
                    outputPane.setText(sf.encipher());
                } else {
                    JOptionPane.showMessageDialog(null, "Please provide a message and a shift value.");
                }
            }
        });
        deButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEmpty(msgTextArea) && !isEmpty(shiftTextField)) {
                    shift = Integer.parseInt(shiftTextField.getText());
                    msg = msgTextArea.getText();
                    sf.setS(shift);
                    sf.setMessage(msg);
                    outputPane.setText(sf.decipher());
                } else {
                    JOptionPane.showMessageDialog(null, "Please provide a message and a shift value.");
                }
            }
        });
        msgTextArea.addComponentListener(new ComponentAdapter() {
        });
        msgTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                outputPane.setText("");
            }
        });
    }

    private boolean isEmpty(JTextComponent t) {
        if(t.getText().equals("")) return true;
        return false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shift Cipher");
        frame.setContentPane(new ShiftCipherGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
