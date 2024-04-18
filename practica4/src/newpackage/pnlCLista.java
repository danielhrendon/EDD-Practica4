package newpackage;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;




public class pnlCLista extends JPanel{
    JLabel lblTitulo, lblInsertar;
    JTextField txtInsertar1;
    JButton btnEliminar, btnBorrar, btnInsertarF,btnReinicio, btnInsertarI;
    JTextArea tAColaC;
    lgColaLista cola;
    
    public pnlCLista(){
        setBounds(100, 150, 800, 500);
        setBackground(new Color(49,54,66));
        setLayout(new GridBagLayout());
        cola = new lgColaLista();
        init();
    }
    public void init(){
        btnEliminar = new JButton("Eliminar elemento");
        btnBorrar = new JButton("Borrar Cola");
        btnInsertarF = new JButton("Insertar Al Final");
        btnInsertarI = new JButton("Insertar Al Inicio");
        btnReinicio = new JButton("Reiniciar");
        txtInsertar1 = new JTextField(10);
        txtInsertar1.setVisible(false);
        tAColaC = new JTextArea(8, 20);
        lblTitulo = new JLabel("COLA LISTA");
        lblTitulo.setFont(new Font("Aptos", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.insets = new Insets(0, 0, 460, 600); 
        gbc.anchor = GridBagConstraints.CENTER;
       
        lblInsertar = new JLabel("Insertar elemento:  ");
        lblInsertar.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblInsertar.setForeground(Color.white);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0; 
        gbc1.gridy = 0; 
        gbc1.insets = new Insets(0, 0, 280, 600); 
        gbc1.anchor = GridBagConstraints.CENTER;
        txtInsertar1.setVisible(true);
        txtInsertar1.setForeground(Color.black);
        txtInsertar1.addKeyListener(new KeyAdapter(){
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
                if(txtInsertar1.getText().length()>2 ){
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "NO INGRESES MAS DE DOS NUMEROS!");
                }
                else {
                    String valida = txtInsertar1.getText() + c;
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
        txtInsertar1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

                if (txtInsertar1.getText().matches("\\d+")) {

                    int numero = Integer.parseInt(txtInsertar1.getText());

                } else {

                    JOptionPane.showMessageDialog(null, "Ingresa un número válido");
                }
            }
        });
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0; 
        gbc2.gridy = 0; 
        gbc2.insets = new Insets(125,180, 400, 550); 
        gbc2.fill = GridBagConstraints.BOTH;
        
        btnEliminar.setForeground(Color.white);
        btnEliminar.setBackground(Color.gray);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
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
        gbc3.insets = new Insets(0, 0, 200, 100); 
        gbc3.anchor = GridBagConstraints.CENTER;
        
        btnBorrar.setForeground(Color.white);
        btnBorrar.setBackground(Color.gray);
        btnBorrar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                try {
                    cola.borrarCola(); 
                    actualizarTextArea(); 
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
        gbc4.insets = new Insets(0, 0, 200, -150); 
        gbc4.anchor = GridBagConstraints.CENTER;

        tAColaC.setForeground(Color.black);
        tAColaC.setText("Este es un texto de muestra.");
        tAColaC.setEnabled(false);
        Font font = tAColaC.getFont();
        float newSize = font.getSize() + 5.0f; 
        tAColaC.setFont(font.deriveFont(newSize));
        JScrollPane scrollPane = new JScrollPane(tAColaC);
        GridBagConstraints gbcTextArea = new GridBagConstraints();
        gbcTextArea.gridx = 0;
        gbcTextArea.gridy = 0;
        gbcTextArea.fill = GridBagConstraints.BOTH;
        gbcTextArea.insets = new Insets(200, 5, 100, 0);

        
        GridBagConstraints gbcr = new GridBagConstraints();
        gbcr.gridx = 0; 
        gbcr.gridy = 0; 
        gbcr.insets = new Insets(2, 0, -400, 100); 
        gbcr.anchor = GridBagConstraints.CENTER;
        
        btnReinicio.setForeground(Color.white);
        btnReinicio.setBackground(Color.gray);
        btnReinicio.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            reinicio();
            }
        });
        
        btnInsertarF.setForeground(Color.white);
        btnInsertarF.setBackground(Color.gray);
        btnInsertarF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    String texto = txtInsertar1.getText();
                    int numero = Integer.parseInt(texto);
                    cola.insertar(texto);
                    txtInsertar1.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } finally {
                    actualizarTextArea(); 
                }
            }
        });
        GridBagConstraints gbcf = new GridBagConstraints();
        gbcf.gridx = 0; 
        gbcf.gridy = 0; 
        gbcf.insets = new Insets(0, 0, 200, 375); 
        gbcf.anchor = GridBagConstraints.CENTER;
        
        btnInsertarI.setForeground(Color.white);
        btnInsertarI.setBackground(Color.gray);
        btnInsertarI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    String texto = txtInsertar1.getText();
                    int numero = Integer.parseInt(texto);
                    cola.insertarAlInicio(texto);
                    txtInsertar1.setText(""); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } finally {
                    actualizarTextArea(); 
                }
            }
        });
        GridBagConstraints gbci = new GridBagConstraints();
        gbci.gridx = 0; 
        gbci.gridy = 0; 
        gbci.insets = new Insets(0, 0, 200,650); 
        gbci.anchor = GridBagConstraints.CENTER;
        
        add(lblTitulo,gbc);
        add(lblInsertar,gbc1);
        add(txtInsertar1,gbc2);
        add(btnEliminar,gbc3);
        add(btnBorrar,gbc4);
        add(btnInsertarF, gbcf);
        add(btnInsertarI, gbci);

        add(btnReinicio, gbcr);
        add(scrollPane, gbcTextArea);
       

    }
    private void actualizarTextArea() {
        tAColaC.setText("");
        lgCLNodo actual = cola.frente;
        while (actual != null) {
            tAColaC.append(actual.elemento.toString()+ "\n");
            actual = actual.siguiente;
        }
    }
    private void reinicio(){
        cola.borrarCola();
        txtInsertar1.setText("");
        tAColaC.setText("");
    }
}
