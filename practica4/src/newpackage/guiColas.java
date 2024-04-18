package newpackage;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author danie
 */
public class guiColas extends JFrame {

    JButton btnCCircular, btnCLineal, btnCLista, btnSalir;
    JPanel pnlCCir, pnlCLineal, pnlCLista;
    JLabel lblText;
    
    public guiColas() {
        setTitle("Practica 4 - COLAS");
        setLayout(null);
        setSize(1000, 720);
        getContentPane().setBackground(Color.lightGray);
        init();
        this.setResizable(false);
    }

    public void init() {
        lblText = new JLabel("SELECCIONAR UN BOTON");
        lblText.setFont(new Font("Aptos", Font.BOLD, 60));
        lblText.setBounds(100, 250, 800, 300);
        
        pnlCCircular pnlCCir = new pnlCCircular();
        pnlCLineal pnlCLineal = new pnlCLineal();
        pnlCLista pnlCLista = new pnlCLista();

        pnlCCir.setVisible(false);
        pnlCLineal.setVisible(false);
        pnlCLista.setVisible(false);
        
        
        btnCCircular = new JButton("COLA CIRCULAR");
        btnCCircular.setFont(new Font("Aptos", Font.BOLD, 20));
        btnCCircular.setBounds(100, 15, 200, 50);
        btnCCircular.setBackground(new Color(132,182,244));
        btnCCircular.setForeground(Color.white);;
        btnCCircular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                pnlCCir.setVisible(true);
                pnlCLineal.setVisible(false);
                pnlCLista.setVisible(false);
            }
        });
        
        btnCLineal = new JButton("COLA LINEAL");
        btnCLineal.setFont(new Font("Aptos", Font.BOLD, 20));
        btnCLineal.setBounds(400, 15, 200, 50);
        btnCLineal.setBackground(new Color(132,182,244));
        btnCLineal.setForeground(Color.white);
        btnCLineal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                pnlCCir.setVisible(false);
                pnlCLineal.setVisible(true);
                pnlCLista.setVisible(false);
            }
        });
        
        btnCLista = new JButton("COLA LISTA");
        btnCLista.setFont(new Font("Aptos", Font.BOLD, 20));
        btnCLista.setBounds(700, 15, 200, 50);
        btnCLista.setBackground(new Color(132,182,244));
        btnCLista.setForeground(Color.white);
        btnCLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                pnlCCir.setVisible(false);
                pnlCLineal.setVisible(false);
                pnlCLista.setVisible(true);
            }
        });        

        btnSalir = new JButton("SALIR");
        btnSalir.setFont(new Font("Aptos", Font.BOLD, 20));
        btnSalir.setBounds(400, 80, 200, 50);
        btnSalir.setBackground(new Color(132,182,244));
        btnSalir.setForeground(Color.white);;
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        add(pnlCCir);
        add(pnlCLineal);
        add(pnlCLista);
        add(btnCCircular);
        add(btnCLineal);
        add(btnCLista);    
        add(btnSalir);
        add(lblText);

    }
}
