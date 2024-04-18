package newpackage;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class pnlCLineal extends JPanel{
    JLabel lblTitulo, lblTama, lblInsertar, lblEstado;
    JTextField txtInsertar, txtTama;
    JButton btnEliminar, btnBorrar, btnInsertar, btnEstado, btnSiguiente, btnReinicio;
    JTextArea tAColaC, tAEstado;
    lgColaLineal cola;
    
    public pnlCLineal(){
        setBounds(100, 150, 800, 500);
        setBackground(new Color(245,245,200));
        setLayout(new GridBagLayout());
        cola = new lgColaLineal();
        init();
    }
    public void init(){
        btnEliminar = new JButton("Eliminar elemento");
        btnBorrar = new JButton("Borrar Cola");
        btnInsertar = new JButton("Insertar");
        btnEstado = new JButton("Estado");
        btnReinicio = new JButton("Reiniciar");
        txtInsertar = new JTextField(10);
        
        btnEliminar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnInsertar.setEnabled(false);
        btnEstado.setEnabled(false);
        btnReinicio.setEnabled(false);
        txtInsertar.setEnabled(false);
        
        lblTitulo = new JLabel("COLA LINEAL");
        lblTitulo.setFont(new Font("Aptos", Font.BOLD, 18));
        lblTitulo.setForeground(Color.red);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.insets = new Insets(0, 0, 460, 600); 
        gbc.anchor = GridBagConstraints.CENTER;
        
        lblTama = new JLabel("Tamaño de la cola: ");
        lblTama.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblTama.setForeground(Color.red);
        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.gridx = 0; 
        gbc0.gridy = 0; 
        gbc0.insets = new Insets(0, 0, 360, 600); 
        gbc.anchor = GridBagConstraints.CENTER;
        
        txtTama = new JTextField(10);
        txtTama.setForeground(Color.red);
        txtTama.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                char c = evt.getKeyChar();
                if (c == KeyEvent.VK_BACK_SPACE) { 
                    return; 
                }
                if (!Character.isDigit(c)) { 
                    evt.consume(); 
                    JOptionPane.showMessageDialog(null, "ingresa solo números.");
                    return;
                }
                if (c <'0'|| c >'9')evt.consume();{
                
                }
                if(txtTama.getText().length()>2 ){
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "NO INGRESES MAS DE DOS NUMEROS!");
                }
                else {
                    String valida = txtTama.getText() + c;
                    if (!valida.isEmpty()) {
                        int b = Integer.parseInt(valida);
                        if (b < 1 || b > 20) {
                            evt.consume();
                            JOptionPane.showMessageDialog(null, "ESCRIBE UN NUMERO ENTRE EL 1 Y EL 20");
                            txtTama.setText("");
                        }
                    }
                }
                
            }   
         });
        txtTama.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

        String tamaStr = txtTama.getText();
        if (!tamaStr.isEmpty()) {
            try {
                int MAXTAMQ = Integer.parseInt(tamaStr) + 1;
                
                cola.actualizarTamaño(MAXTAMQ);

                
                btnEliminar.setEnabled(true);
                btnBorrar.setEnabled(true);
                btnInsertar.setEnabled(true);
                btnEstado.setEnabled(true);
                txtInsertar.setEnabled(true);
                btnReinicio.setEnabled(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número valido como tamaño maximo de la cola.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el tamaño maximo de la cola.");
                }
            }
        });
        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.gridx = 0; 
        gbc10.gridy = 0; 
        gbc10.insets = new Insets(80,180, 450, 550);
        gbc10.fill = GridBagConstraints.BOTH;
        
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setForeground(Color.red);
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el tamaño máximo de la cola desde el JTextField txtTama
                String tamaStr = txtTama.getText();
                if (!tamaStr.isEmpty()) {
                    try {
                        int MAXTAMQ = Integer.parseInt(tamaStr) + 1;
                        // Crear una nueva instancia de lgColaLineal con el tamaño máximo definido
                        cola.actualizarTamaño(MAXTAMQ);
                        btnEliminar.setEnabled(true);
                        btnBorrar.setEnabled(true);
                        btnInsertar.setEnabled(true);
                        btnEstado.setEnabled(true);
                        txtInsertar.setEnabled(true);
                        btnReinicio.setEnabled(true);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido como tamaño máximo de la cola.");
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el tamaño máximo de la cola.");
                }
            }
        });
        
        GridBagConstraints gbc11 = new GridBagConstraints();
        gbc11.gridx = 0; 
        gbc11.gridy = 0; 
        gbc11.insets = new Insets(0, 0, 350,150); 
        gbc11.anchor = GridBagConstraints.CENTER;
        
        lblInsertar = new JLabel("Insertar elemento:  ");
        lblInsertar.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblInsertar.setForeground(Color.red);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0; 
        gbc1.gridy = 0; 
        gbc1.insets = new Insets(0, 0, 280, 600); 
        gbc1.anchor = GridBagConstraints.CENTER;

        txtInsertar.setForeground(Color.red);
        txtInsertar.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                char c = evt.getKeyChar();
                if (c == KeyEvent.VK_BACK_SPACE) { 
                    return; 
                }
                if (!Character.isDigit(c)) { 
                    evt.consume(); 
                    JOptionPane.showMessageDialog(null, "ingresa solo números.");
                    return;
                }
                if (c <'0'|| c >'9')evt.consume();{
                
                }
                if(txtInsertar.getText().length()>2 ){
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "NO INGRESES MAS DE DOS NUMEROS!");
                }
                else {
                    String valida = txtInsertar.getText() + c;
                    if (!valida.isEmpty()) {
                        int b = Integer.parseInt(valida);
                        if (b < 1 || b > 100) {
                            evt.consume();
                            JOptionPane.showMessageDialog(null, "ESCRIBE UN NUMERO ENTRE EL 1 Y EL 100");
                        }
                    }
                }
                
            }   
         });
        
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0; 
        gbc2.gridy = 0; 
        gbc2.insets = new Insets(125,180, 400, 550); 
        gbc2.fill = GridBagConstraints.BOTH;
        
        btnEliminar.setForeground(Color.red);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSiguiente.setEnabled(false);
                try {
                    cola.quitar();
                    actualizarTextArea(); 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0; 
        gbc3.gridy = 0; 
        gbc3.insets = new Insets(0, 0, 200, 375); 
        gbc3.anchor = GridBagConstraints.CENTER;
        
        btnBorrar.setForeground(Color.red);
        btnBorrar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                try {
                    cola.borrarCola(); // Llama al método para borrar la cola
                    actualizarTextArea(); // Actualiza el JTextArea con el mensaje
                    reinicio();
                    tAColaC.setText("La Cola se ha BORRADO completamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0; 
        gbc4.gridy = 0; 
        gbc4.insets = new Insets(0, 0, 200, 125); 
        gbc4.anchor = GridBagConstraints.CENTER;
        
        btnInsertar.setForeground(Color.red);
        btnInsertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSiguiente.setEnabled(false);
                try {
                    String texto = txtInsertar.getText();
                    int numero = Integer.parseInt(texto);
                    cola.insertar(texto);
                    txtInsertar.setText("");
                    actualizarTextArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } 
            }
        });
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0; 
        gbc5.gridy = 0; 
        gbc5.insets = new Insets(0, 0, 200, 600); 
        gbc5.anchor = GridBagConstraints.CENTER;
        
        btnEstado.setForeground(Color.red);
        btnEstado.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                btnSiguiente.setEnabled(false);
                try {
                    
                    actualizarEstadoCola(); 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0; 
        gbc6.gridy = 0; 
        gbc6.insets = new Insets(0, 0, 200, -60); 
        gbc6.anchor = GridBagConstraints.CENTER;
        
        tAColaC = new JTextArea(8, 20);
        tAColaC.setForeground(Color.red);
        tAColaC.setText("Este es un texto de muestra.");
        tAColaC.setEnabled(false); 
        Font font = tAColaC.getFont();
        float newSize = font.getSize() + 5.0f; // Aumentar el tamaño de la fuente en 5 puntos
        tAColaC.setFont(font.deriveFont(newSize));
        JScrollPane scrollPane = new JScrollPane(tAColaC);
        GridBagConstraints gbcTextArea = new GridBagConstraints();
        gbcTextArea.gridx = 0;
        gbcTextArea.gridy = 0;
        gbcTextArea.fill = GridBagConstraints.BOTH;
        gbcTextArea.insets = new Insets(200, 5, 100, 0);
        
        tAEstado = new JTextArea();
        tAEstado.setForeground(Color.yellow);
        tAEstado.setEnabled(false);
        GridBagConstraints gbcTextArea2 = new GridBagConstraints();
        gbcTextArea2.gridx = 0;
        gbcTextArea2.gridy = 0;
        gbcTextArea2.fill = GridBagConstraints.BOTH;
        gbcTextArea2.insets = new Insets(175, 600, 378, 5);
        
        lblEstado = new JLabel("Estado de la cola:  ");
        lblEstado.setFont(new Font("Aptos", Font.PLAIN, 14));
        lblEstado.setForeground(Color.red);
        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0; 
        gbc7.gridy = 0; 
        gbc7.insets = new Insets(0, 0, 200, -275); 
        gbc7.anchor = GridBagConstraints.CENTER;
        
        GridBagConstraints gbcr = new GridBagConstraints();
        gbcr.gridx = 0; 
        gbcr.gridy = 0; 
        gbcr.insets = new Insets(2, 0, -400, 0); 
        gbcr.anchor = GridBagConstraints.CENTER;
        
        btnReinicio.setForeground(Color.red);
        btnReinicio.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            reinicio();
            }
        });
        
        add(txtTama,gbc10);
        add(btnSiguiente, gbc11);
        add(lblTama, gbc0);
        add(lblTitulo,gbc);
        add(lblInsertar,gbc1);
        add(txtInsertar,gbc2);
        add(btnEliminar,gbc3);
        add(btnBorrar,gbc4);
        add(btnInsertar,gbc5);
        add(btnEstado, gbc6);
        add(lblEstado, gbc7);
        add(tAEstado,gbcTextArea2);
        add(btnReinicio, gbcr);
        add(scrollPane, gbcTextArea);
       

    }
    private void actualizarTextArea() {
        tAColaC.setText("");
        int tempFrente = cola.frente;
        int tempFin = cola.fin;
        if (!cola.colaVacia()) {
            while (tempFrente != tempFin) {
                tAColaC.append(cola.listaCola[tempFrente].toString() + "\n");
                tempFrente = (tempFrente + 1) % cola.maxTamaño;
            }
            tAColaC.append(cola.listaCola[tempFrente].toString() + "\n");
        } else {
            tAColaC.setText("La cola está vacía.");
        }
    }
    private void reinicio(){
        cola.borrarCola();

        txtTama.setText("");
        txtInsertar.setText("");

        tAColaC.setText("");
        tAEstado.setText("");

        btnEliminar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnInsertar.setEnabled(false);
        btnEstado.setEnabled(false);
        txtInsertar.setEnabled(false);

        btnSiguiente.setEnabled(true);
    }
    private void actualizarEstadoCola() {
    try {
        if (cola.colaVacia()) {
            tAEstado.setText("La cola está vacía");
        } else if  (cola.colaLlena()) {
            tAEstado.setText("La cola está llena");
        } else {
            tAEstado.setText("La cola no está llena o vacía");
        }                   
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }   
    
}
                
    
       
